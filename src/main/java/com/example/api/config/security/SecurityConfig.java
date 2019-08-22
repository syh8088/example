package com.example.api.config.security;

import com.example.api.config.handler.AuthenticationSuccessHandler;
import com.example.api.config.handler.CustomAuthenticationProvider;
import com.example.api.config.handler.OAuthSuccessHandler;
import com.example.api.config.handler.UserServiceHandler;
import com.example.api.model.enums.OauthType;
import com.example.api.model.wrappper.ClientResources;
import com.example.api.service.CustomPersistentTokenService;
import com.example.api.service.member.MemberService;
import com.example.api.util.security.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.CompositeFilter;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final static String homeUrl = "/main";
    private final UserServiceHandler userServiceHandler;
    private final AuthenticationSuccessHandler authenticationSuccessHandler;
    private final OAuth2ClientContext oauth2ClientContext;
    private final MemberService memberService;

    @Autowired
    private  CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    public SecurityConfig(UserServiceHandler userServiceHandler, AuthenticationSuccessHandler authenticationSuccessHandler, OAuth2ClientContext oauth2ClientContext, MemberService memberService) {
        this.userServiceHandler = userServiceHandler;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
        this.oauth2ClientContext = oauth2ClientContext;
        this.memberService = memberService;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new CustomPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(homeUrl, homeUrl + "/facebook/**",homeUrl + "/social_login", "/social_login.html", "/connect/facebook", "/webjars/**", "/v2/api-docs", "/swagger-resources/configuration/ui", "/swagger-resources", "/swagger-resources/configuration/security", "/swagger-ui.html", "/webjars/**").permitAll()
                .antMatchers(homeUrl + "/admin/**").hasAnyAuthority("ADMIN")
                .antMatchers(homeUrl + "/memberGroups/**").hasAnyAuthority("ADMIN")
                .antMatchers(homeUrl + "/writer/**").hasAuthority("WRITER")
                .anyRequest().authenticated()
                .and().formLogin().successHandler(authenticationSuccessHandler)
                .and().logout().logoutSuccessUrl(homeUrl)
                .and().rememberMe()
                .key("hoon")
                .rememberMeParameter("remember-me")
                .rememberMeCookieName("syh-cookie")
                .tokenValiditySeconds(10000)
                .tokenRepository(rememberMeTokenService())
                .and().csrf().disable();

        http.addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/h2-console/**").antMatchers("/memberGroups/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("1234").authorities("ADMIN").and()
                .withUser("writer").password("1234").authorities("WRITER").and()
                .withUser("client").password("1234").authorities("CLIENT");

        //auth.userDetailsService(userServiceHandler)
        //        .passwordEncoder(passwordEncoder());
        auth.authenticationProvider(customAuthenticationProvider);
    }

    private Filter ssoFilter() {
        CompositeFilter filter = new CompositeFilter();
        List<Filter> filters = new ArrayList<>();
        filters.add(ssoFilter(naver(), OauthType.NAVER));
        filters.add(ssoFilter(google(), OauthType.GOOGLE));
        filter.setFilters(filters);
        return filter;
    }

    private Filter ssoFilter(ClientResources client, OauthType type) {
        OAuth2ClientAuthenticationProcessingFilter filter = new OAuth2ClientAuthenticationProcessingFilter("/login/" + type);
        OAuth2RestTemplate template = new OAuth2RestTemplate(client.getClient(), oauth2ClientContext);
        filter.setRestTemplate(template);
        filter.setTokenServices(new UserInfoTokenServices(client.getResource().getUserInfoUri(), client.getClient().getClientId()));
        filter.setAuthenticationSuccessHandler(new OAuthSuccessHandler(type, memberService));
        return filter;
    }

    @Bean
    @ConfigurationProperties("google")
    ClientResources google() {
        return new ClientResources();
    }

    @Bean
    @ConfigurationProperties("naver")
    ClientResources naver() {
        return new ClientResources();
    }

    @Bean
    public FilterRegistrationBean oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setOrder(-100);
        return registration;
    }

    @Bean
    public CustomPersistentTokenService rememberMeTokenService() {
        return new CustomPersistentTokenService();
    }
}
