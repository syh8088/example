package com.example.api.config.handler;

import com.example.api.exception.BaseException;
import com.example.api.model.entities.member.Member;
import com.example.api.model.enums.OauthType;
import com.example.api.model.wrappper.OauthIDAndName;
import com.example.api.service.member.MemberService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OAuthSuccessHandler implements AuthenticationSuccessHandler {

    private final OauthType type;
    private final MemberService memberService;

    public OAuthSuccessHandler(OauthType type, MemberService memberService) {
        this.type = type;
        this.memberService = memberService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Member member = memberService.getMemberByOauthTypeAndId(type, authentication.getName());
        List<GrantedAuthority> grants = null;

        if (member == null) {
            try {
                member = makeNewMemberByType(authentication, type);
                memberService.savePoint(200, "member_register", member.getMemberNo());
            } catch (BaseException e) {
                e.printStackTrace();
            }
        } else {
            //grants = member.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
            grants = createDefaultPermissions();
            memberService.savePoint(10, "member_login", member.getMemberNo());
        }

        if (grants == null || grants.isEmpty()) {
            grants = createDefaultPermissions();
        }

        assert member != null;
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(new User(member.getId(), member.getPassword(), grants), null, grants));

        try {
            response.sendRedirect("/main");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<GrantedAuthority> createDefaultPermissions() {
        return Collections.singletonList(new SimpleGrantedAuthority("ADMIN"));
    }

    private Member makeNewMemberByType(Authentication authentication, OauthType type) throws BaseException {

        Member member = new Member();
        member.setPassword(UUID.randomUUID().toString());
        member.setOauthType(type);

        OauthIDAndName oauthIDAndName = getOauthIDAndNameByType(authentication, type);
        member.setEmail(oauthIDAndName.getName());
        member.setId(oauthIDAndName.getName());
        member.setOauthId(oauthIDAndName.getId());
        member.setSnsYn("Y");
        return memberService.saveSomethingMember(member);
    }


    private OauthIDAndName getOauthIDAndNameByType(Authentication authentication, OauthType type) {
        OauthIDAndName oauthIDAndName = new OauthIDAndName();

        Map details = (Map) ((OAuth2Authentication) authentication).getUserAuthentication().getDetails();
        switch (type) {
            case GOOGLE:
                oauthIDAndName.setId(authentication.getName());
                oauthIDAndName.setName(details.get("email").toString());
                break;
            case NAVER:
                Map detailsByNaver = (Map) details.get("response");
                oauthIDAndName.setId(detailsByNaver.get("id").toString());
                oauthIDAndName.setName(detailsByNaver.get("nickname").toString());
        }

        return oauthIDAndName;
    }
}
