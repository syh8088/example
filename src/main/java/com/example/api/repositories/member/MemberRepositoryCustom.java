package com.example.api.repositories.member;

import com.example.api.model.entities.member.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    Member getMemberByNo(long no);

    Member getMemberById(String name);

    List<Member> selectAll();
}
