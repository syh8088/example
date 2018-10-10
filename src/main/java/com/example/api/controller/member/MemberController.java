package com.example.api.controller.member;

import com.example.api.model.entities.member.Member;
import com.example.api.model.request.MemberRequest;
import com.example.api.service.member.MemberService;
import com.example.api.util.validator.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("members")
@Api(tags = "Member")
public class MemberController {

    private final MemberService memberService;
    private final Validator validator;

    @Autowired
    public MemberController(MemberService memberService, Validator validator) {
        this.memberService = memberService;
        this.validator = validator;
    }

    @GetMapping("{no}/types/{type}")
    @ApiOperation(value = "Get member into type", notes = "Returns the member of the type")
    public ResponseEntity<Member> getMember(@PathVariable("no") @ApiParam(value = "Member no", defaultValue = "1") long no,
                                            @PathVariable(value = "type", required = false) @ApiParam(value = "Fetching type", defaultValue = "queryDSL") String type) {
        return ResponseEntity.ok().body(memberService.getMember(no, type));
    }

    @PostMapping
    @ApiOperation(value = "Create member", notes = "Creates a member and returns the entity.")
    public ResponseEntity<?> saveMember(@RequestBody @ApiParam(value = "Member") @Valid MemberRequest memberRequest, BindingResult bindingResult, Model model) throws Exception {

        // 단순 검증
        if (bindingResult.hasErrors()) {
            return ResponseEntity.ok(bindingResult.getAllErrors());
        }

        // 데이터 유효성 검증
        validator.member(memberRequest);

        Member member = new Member();
        BeanUtils.copyProperties(memberRequest, member);

        return ResponseEntity.ok().body(memberService.saveSomethingMember(member));
    }

    @PutMapping
    @ApiOperation(value = "Update member", notes = "Updates a member and returns the entity.")
    public ResponseEntity<Member> modifyMember(@RequestBody Member member) {
        return ResponseEntity.ok().body(memberService.modifyNameByName(member));
    }
}
