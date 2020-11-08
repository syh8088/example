package com.example.api.repositories.member;

import com.example.api.model.entities.member.Member;
import com.example.api.model.entities.member.QMember;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

public class MemberRepositoryImpl extends QueryDslRepositorySupport implements MemberRepositoryCustom {


    QMember qMember = QMember.member;

    public MemberRepositoryImpl() {
        super(Member.class);
    }

    @Override
    public Member getMemberByNo(long no) {
        return from(qMember)
                .where(qMember.memberNo.eq(no))
                .fetchOne();
    }

    @Override
    public Member getMemberById(String name) {
        return from(qMember)
                .leftJoin(qMember.roles).fetchJoin()
                .where(qMember.id.eq(name))
                .fetchOne();
    }

    @Override
    public List<Member> selectAll() {
        return from(qMember)
                .join(qMember.memberGroup)
                .fetch();
    }
}
