package com.example.api.repositories.member;

import com.example.api.entities.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

    Member findByMemberNo(long no);

    @Query(value = "select m from Member m where m.memberNo = :no", nativeQuery = false)
    Member selectByNo(@Param("no") long no);
}
