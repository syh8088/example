package com.example.api.controller.member;

import com.example.api.entities.member.MemberGroup;
import com.example.api.entities.member.MemberGroupViewModel;
import com.example.api.service.member.MemberGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("memberGroups")
@Api(tags = "MemberGroup")
@Slf4j
public class MemberGroupController {
    private final MemberGroupService memberGroupService;

    @Autowired
    public MemberGroupController(MemberGroupService memberGroupService) {
        this.memberGroupService = memberGroupService;
    }

    @GetMapping("{no}/types/{type}")
    @ApiOperation(value = "Get group into type", notes = "Returns the group and each member of the type.")
    public ResponseEntity<MemberGroup> getMemberGroup(@PathVariable("no") @ApiParam(value = "Group no", defaultValue = "1") long no,
                                                      @PathVariable("type") @ApiParam(value = "Fetching type", defaultValue = "queryDSL") String type,
                                                      HttpServletRequest request) {
        log.info("api-key header : " + request.getHeader("api_key"));
        return ResponseEntity.ok().body(memberGroupService.getMemberGroup(no, type));
    }

    @GetMapping("{no}/MemberGroupViewModel")
    @ApiOperation(value = "Get group(front-only)", notes = "Returns front-only group model.")
    public ResponseEntity<MemberGroupViewModel> getMemberGroupViewModel(@PathVariable("no") @ApiParam(value = "Group no", defaultValue = "1") long no) {
        return ResponseEntity.ok().body(memberGroupService.getMemberGroupViewModel(no));
    }
}
