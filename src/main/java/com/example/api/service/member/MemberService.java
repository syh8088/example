package com.example.api.service.member;

import com.example.api.entities.member.Member;
import com.example.api.entities.member.MemberGroup;
import com.example.api.repositories.member.MemberMapper;
import com.example.api.repositories.member.MemberRepository;
import com.example.api.util.Constants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MemberService {

    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;

    private static final String IGNORE_FIELD_WHEN_MODIFY[] = {Constants.DELETE_YN, Constants.REGISTER_YMDT, Constants.UPDATE_YMDT};

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
                member = memberRepository.findByNo(no);
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

    public Member saveSomethingMember(Member member) {
        return memberRepository.save(member);
    }

    @Transactional
    public Member modifyNameByName(Member member) {
        Member originMember = memberRepository.findOne(member.getNo());

        BeanUtils.copyProperties(member, originMember, IGNORE_FIELD_WHEN_MODIFY);
        return member;
    }


}
