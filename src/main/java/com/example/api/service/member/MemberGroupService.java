package com.example.api.service.member;

import com.example.api.model.entities.member.MemberGroup;
import com.example.api.model.entities.member.MemberGroupViewModel;
import com.example.api.repositories.member.MemberGroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

        // lazy와 eager의 차이를 확인
        memberGroup.getMembers().forEach(member -> {
            member.getRoles().forEach(role -> log.info(role.toString()));
        });

        return memberGroup;
    }

    public MemberGroupViewModel getMemberGroupViewModel(long no) {
        return memberGroupRepository.selectMemberGroupViewModel(no);
    }

    @Cacheable(cacheNames = "MemberGroup", key = "'group:' +#no")
    public MemberGroupViewModel getMemberGroupViewModelByCache(long no) {
        return memberGroupRepository.selectMemberGroupViewModel(no);
    }
}
