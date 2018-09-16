package com.example.api.repositories.member;

import com.example.api.entities.member.Member;

public interface MemberRepositoryCustom {
    Member getMemberByNo(long no);

    Member getMemberById(String name);
}
