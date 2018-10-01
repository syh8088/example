package com.example.api.repositories.member;

import com.example.api.model.entities.member.Member;
import com.example.api.model.entities.member.QMember;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

public class MemberRepositoryImpl extends QueryDslRepositorySupport implements MemberRepositoryCustom {


    QMember member = QMember.member;

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

        return from(member)
                .where(member.no.eq(no))
                .fetchOne();
    }

    @Override
    public Member getMemberById(String name) {
        return from(member)
                .leftJoin(member.roles).fetchJoin()
                .where(member.id.eq(name))
                .fetchOne();
    }
}
