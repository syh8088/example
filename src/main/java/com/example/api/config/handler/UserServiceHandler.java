package com.example.api.config.handler;

import com.example.api.model.entities.member.Member;
import com.example.api.repositories.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceHandler implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Autowired
    public UserServiceHandler(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.getMemberById(username);

        if (member == null) {
            throw new UsernameNotFoundException("unsername not found");
        }

        List<GrantedAuthority> grants = member.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

        return new User(member.getId(), member.getPassword(), grants);
    }
}
