package com.example.api.service.member;

import com.example.api.entities.member.Member;
import com.example.api.repositories.member.MemberMapper;
import com.example.api.repositories.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberMapper memberMapper, MemberRepository memberRepository) {
        this.memberMapper = memberMapper;
        this.memberRepository = memberRepository;
    }

    public Member getMember(long no, String type) {

        Member member;
        switch (type) {
            case "default":
                member = memberRepository.findOne(no);
                break;
            case "query":
                member = memberRepository.findByMemberNo(no);
                break;
            case "JPQL":
                member = memberRepository.selectByNo(no);
                break;
            case "queryDSL":
                member = memberRepository.getMemberByNo(no);
                break;
            default:
                member = memberMapper.selectById(no);
        }
        return member;
    }
}
