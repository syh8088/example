package com.example.api.Nplus1Problem;

import com.example.api.controller.member.MemberController;
import com.example.api.repositories.member.MemberRepository;
import com.example.api.service.member.MemberService;
import com.example.api.util.validator.Validator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Nplus1Problem {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        //this.mockMvc = MockMvcBuilders.standaloneSetup(new MemberController(new MemberService(), new Validator())).setViewResolvers((viewName, locale) -> )
    }

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    public void memberNplus1Problem() {
        BDDMockito.given(memberRepository.findByMemberNo(1));

    }

/*

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
*/


}
