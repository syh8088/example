package com.example.api.repositories.member;

import com.example.api.entities.member.Member;
import com.example.api.entities.point.Point;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapper {
    Member selectById(long no);

    int updateMemberPoint(Point point);
}
