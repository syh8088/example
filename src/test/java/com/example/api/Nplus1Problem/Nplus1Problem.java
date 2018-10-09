package com.example.api.Nplus1Problem;

import com.example.api.repositories.member.MemberRepository;
import com.example.api.service.member.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Nplus1Problem {

    private MemberService memberService;
    private MemberRepository memberRepository;


    @Autowired
    public void Nplus1Problem(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    @Test
    public void memberNplus1Problem() {

        memberService.getMember(1, "All");

    }


}
