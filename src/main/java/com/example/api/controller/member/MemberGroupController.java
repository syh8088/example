package com.example.api.controller.member;

import com.example.api.entities.member.MemberGroup;
import com.example.api.entities.member.MemberGroupViewModel;
import com.example.api.service.member.MemberGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("memberGroups")
public class MemberGroupController {
    private final MemberGroupService memberGroupService;

    @Autowired
    public MemberGroupController(MemberGroupService memberGroupService) {
        this.memberGroupService = memberGroupService;
    }

    @GetMapping("{no}/types/{type}")
    public ResponseEntity<MemberGroup> getMemberGroup(@PathVariable("no") long no,
                                                      @PathVariable("type") String type) {
        return ResponseEntity.ok().body(memberGroupService.getMemberGroup(no, type));
    }
    
    @GetMapping("{no}/MemberGroupViewModel")
    public ResponseEntity<MemberGroupViewModel> getMemberGroupViewModel(@PathVariable("no") long no) {
        return ResponseEntity.ok().body(memberGroupService.getMemberGroupViewModel(no));
    }
}
