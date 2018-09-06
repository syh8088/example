package com.example.api.controller.member;

import com.example.api.entities.member.Member;
import com.example.api.service.member.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("members")
@Api(tags = "Member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("{no}/types/{type}")
    @ApiOperation(value = "Get member into type", notes = "Returns the member of the type")
    public ResponseEntity<Member> getMember(@PathVariable("no") @ApiParam(value = "Member no", defaultValue = "1") long no,
                                            @PathVariable(value = "type", required = false) @ApiParam(value = "Fetching type", defaultValue = "queryDSL") String type) {
        return ResponseEntity.ok().body(memberService.getMember(no, type));
    }

    @PostMapping
    @ApiOperation(value = "Create member", notes = "Creates a member and returns the entity.")
    public ResponseEntity<Member> saveMember(@RequestBody @ApiParam(value = "Member") Member member) {
        return ResponseEntity.ok().body(memberService.saveSomethingMember(member));
    }

    @PutMapping
    @ApiOperation(value = "Update member", notes = "Updates a member and returns the entity.")
    public ResponseEntity<Member> modifyMember(@RequestBody Member member) {
        return ResponseEntity.ok().body(memberService.modifyNameByName(member));
    }
}
