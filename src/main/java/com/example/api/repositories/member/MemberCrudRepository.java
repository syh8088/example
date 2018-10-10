package com.example.api.repositories.member;

import com.example.api.model.entities.member.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberCrudRepository extends CrudRepository<Member, Long> {

}
