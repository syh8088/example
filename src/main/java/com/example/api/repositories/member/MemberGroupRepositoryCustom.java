package com.example.api.repositories.member;

import com.example.api.model.entities.member.MemberGroup;
import com.example.api.model.entities.member.MemberGroupViewModel;

public interface MemberGroupRepositoryCustom {
    MemberGroup selectByNo(long no);

    MemberGroupViewModel selectMemberGroupViewModel(long no);
}
