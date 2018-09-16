package com.example.api.config.handler;

import com.example.api.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private MemberService memberService;

    @Autowired
    public AuthenticationSuccessHandler(MemberService memberService) {
        this.memberService = memberService;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String userId = userDetails.getUsername();
        memberService.modifyAuthenticationSuccess(userId);

        response.sendRedirect("/main");
      //  super.onAuthenticationSuccess(request, response, authentication);
    }
}
