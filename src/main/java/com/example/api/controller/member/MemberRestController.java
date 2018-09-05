package com.example.api.controller.member;

import com.example.api.entities.member.Member;
import com.example.api.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("members")
public class MemberRestController {

    private final MemberService memberService;

    @Autowired
    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("{no}/types/{type}")
    public ResponseEntity<Member> getMember(@PathVariable("no") long no,
                                            @PathVariable(value = "type", required = false) String type) {
        return ResponseEntity.ok().body(memberService.getMember(no, type));
    }


}
