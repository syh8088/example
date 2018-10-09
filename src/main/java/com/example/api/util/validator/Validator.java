package com.example.api.util.validator;

import com.example.api.error.errorCode.MemberErrorCode;
import com.example.api.error.exception.MemberException;
import com.example.api.model.request.MemberRequest;
import com.example.api.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validator {
    @Autowired
    private MemberService memberService;

    public void member(MemberRequest memberRequest) {

        if (memberRequest.getPassword().length() < 10) {
            throw new MemberException(MemberErrorCode.NOT_VALID_PASSWORD_LENGTH);
        }

        if (memberService.isAlreadyRegisteredId(memberRequest.getId())) {
            throw new MemberException(MemberErrorCode.ALREADY_JOIN_ID);
        }
    }
}
