package com.example.api.repositories.member;

import com.example.api.model.entities.member.MemberGroup;
import com.example.api.model.entities.member.MemberGroupViewModel;
import com.example.api.model.entities.member.QMember;
import com.example.api.model.entities.member.QMemberGroup;
import com.querydsl.core.types.Projections;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

public class MemberGroupRepositoryImpl extends QueryDslRepositorySupport implements MemberGroupRepositoryCustom {


    QMemberGroup qMemberGroup = QMemberGroup.memberGroup;
    QMember qMember = QMember.member;


    public MemberGroupRepositoryImpl() {
        super(MemberGroup.class);
    }

    @Override
    public MemberGroup selectByNo(long no) {
        return from(qMemberGroup)
                .leftJoin(qMemberGroup.members, qMember).fetchJoin()
                .leftJoin(qMember.roles).fetchJoin()
                .where(qMemberGroup.memberGroupNo.eq(no))
                .fetchOne();
    }

    @Override
    public MemberGroupViewModel selectMemberGroupViewModel(long no) {
        return from(qMemberGroup)
                .select(
                        Projections.bean(MemberGroupViewModel.class,
                                qMemberGroup.memberGroupNo,
                                qMemberGroup.name.as("customMsg")))
                .where(qMemberGroup.memberGroupNo.eq(no))
                .fetchOne();
    }
}
