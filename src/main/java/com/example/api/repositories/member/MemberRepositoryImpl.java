package com.example.api.repositories.member;

import com.example.api.model.entities.member.Member;
import com.example.api.model.entities.member.QMember;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

public class MemberRepositoryImpl extends QueryDslRepositorySupport implements MemberRepositoryCustom {


    QMember qMember = QMember.member;

    /**
     * Creates a new {@link QueryDslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
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
}
