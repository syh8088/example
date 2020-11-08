package com.example.api;

import com.example.api.model.entities.member.Member;
import com.example.api.repositories.member.MemberGroupRepository;
import com.example.api.repositories.member.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JPQLNplus1Problem {

    @Autowired
    private MemberGroupRepository memberGroupRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void JPQL에서_즉시로딩시_NPlus1_문제이슈() throws Exception {
        List<Member> memberList = memberRepository.selectAll();
        System.out.println("memberList = " + memberList);
    }
}
