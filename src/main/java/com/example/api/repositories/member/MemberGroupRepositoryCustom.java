package com.example.api.repositories.member;

import com.example.api.entities.member.MemberGroup;
import com.example.api.entities.member.MemberGroupViewModel;

public interface MemberGroupRepositoryCustom {
    MemberGroup selectByNo(long no);

    MemberGroupViewModel selectMemberGroupViewModel(long no);
}
