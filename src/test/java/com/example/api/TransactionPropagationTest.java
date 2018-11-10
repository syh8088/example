package com.example.api;

import com.example.api.model.entities.member.Member;
import com.example.api.service.member.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionPropagationTest {

  /*  private final MemberService memberService;

    @Autowired
    public TransactionPropagationTest(MemberService memberService) {
        this.memberService = memberService;
    }

    @Test
    public void propagation() {

        Member member = new Member();
        member.setEmail("werwer@weqrwer.com");
        member.setName("sseew");
        member.setPassword("1234");

        Member save = memberService.saveTransactionPropagationTest(member);
        System.out.println(save);
    }*/

}
