package com.example.api.repositories.member;

import com.example.api.model.entities.member.Member;
import com.example.api.model.enums.OauthType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

    Member findByNo(long no);

    Member findByIdOrAndEmail(String id, String email);

    @Query(value = "select m from Member m where m.no = :no", nativeQuery = false)
    Member selectByNo(@Param("no") long no);

    Member findByOauthTypeAndOauthId(OauthType oauthType, String oauthId);
}
