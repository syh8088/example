package com.example.api.service.member;

import com.example.api.entities.member.MemberGroup;
import com.example.api.entities.member.MemberGroupViewModel;
import com.example.api.repositories.member.MemberGroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class MemberGroupService {

    private final MemberGroupRepository memberGroupRepository;

    @Autowired
    public MemberGroupService(MemberGroupRepository memberGroupRepository) {
        this.memberGroupRepository = memberGroupRepository;
    }


    @Transactional
    public MemberGroup getMemberGroup(long no, String type) {

        MemberGroup memberGroup;
        switch (type) {
            case "queryDSL":
                memberGroup = memberGroupRepository.selectByNo(no);
                break;
            default:
                memberGroup = memberGroupRepository.findOne(no);
        }

        // NOTE #4-14 이곳에서 lazy와 eager의 차이를 확인해 보세요.
        memberGroup.getMembers().forEach(member -> log.info("something"));

        return memberGroup;
    }

    public MemberGroupViewModel getMemberGroupViewModel(long no) {
        return memberGroupRepository.selectMemberGroupViewModel(no);
    }
}
