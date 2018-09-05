package com.example.api.repositories.member;

import com.example.api.entities.member.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapper {
    Member selectById(long no);
}
