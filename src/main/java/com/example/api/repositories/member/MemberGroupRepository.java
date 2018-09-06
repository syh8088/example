package com.example.api.repositories.member;

import com.example.api.entities.member.MemberGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberGroupRepository extends JpaRepository<MemberGroup, Long>, MemberGroupRepositoryCustom {
}
