package com.example.api.config;

import com.example.api.config.handler.AuthenticationSuccessHandler;
import com.example.api.config.handler.UserServiceHandler;
import com.example.api.util.security.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final static String homeUrl = "/main";
    private final UserServiceHandler userServiceHandler;
    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    public SecurityConfig(UserServiceHandler userServiceHandler, AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.userServiceHandler = userServiceHandler;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new CustomPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(homeUrl, "/v2/api-docs", "/swagger-resources/configuration/ui", "/swagger-resources", "/swagger-resources/configuration/security", "/swagger-ui.html", "/webjars/**").permitAll()
                .antMatchers(homeUrl + "/admin/**").hasAnyAuthority("ADMIN")
                .antMatchers(homeUrl + "/writer/**").hasAuthority("WRITER")
                .anyRequest().authenticated()
                .and().formLogin().successHandler(authenticationSuccessHandler)
                .and().logout().logoutSuccessUrl(homeUrl)
                .and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("1234").authorities("ADMIN").and()
                .withUser("writer").password("1234").authorities("WRITER").and()
                .withUser("client").password("1234").authorities("CLIENT");
        auth.userDetailsService(userServiceHandler)
                .passwordEncoder(passwordEncoder());
    }

}
