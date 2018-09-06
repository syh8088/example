package com.example.api.repositories.member;

import com.example.api.entities.member.MemberGroup;
import com.example.api.entities.member.MemberGroupViewModel;
import com.example.api.entities.member.QMember;
import com.example.api.entities.member.QMemberGroup;
import com.querydsl.core.types.Projections;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

public class MemberGroupRepositoryImpl extends QueryDslRepositorySupport implements MemberGroupRepositoryCustom {

    QMemberGroup memberGroup = QMemberGroup.memberGroup;
    QMember member = QMember.member;

    public MemberGroupRepositoryImpl() {
        super(MemberGroup.class);
    }

    @Override
    public MemberGroup selectByNo(long no) {
        return from(memberGroup)
                .leftJoin(memberGroup.members, member).fetchJoin()
                .leftJoin(member.roles).fetchJoin()
                .where(memberGroup.memberGroupNo.eq(no))
                .fetchOne();
    }

    @Override
    public MemberGroupViewModel selectMemberGroupViewModel(long no) {
        return from(memberGroup)
                .select(
                        Projections.bean(MemberGroupViewModel.class,
                                memberGroup.memberGroupNo,
                                memberGroup.name.as("customMsg")))
                .where(memberGroup.memberGroupNo.eq(no))
                .fetchOne();
    }
}
