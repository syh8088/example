package com.example.api.service.member;

import com.example.api.entities.member.Member;
import com.example.api.entities.point.Point;
import com.example.api.exception.ApiException;
import com.example.api.repositories.member.MemberMapper;
import com.example.api.repositories.member.MemberRepository;
import com.example.api.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MemberService {

    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;

    private static final String IGNORE_FIELD_WHEN_MODIFY[] = {Constants.DELETE_YN, Constants.REGISTER_YMDT, Constants.UPDATE_YMDT, Constants.EMAIL, Constants.ID, Constants.NO};

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

    public Member getMemberById(String userId) {
        return memberRepository.getMemberById(userId);
    }

    public Member saveSomethingMember(Member member) throws ApiException {

        // id, email 중복 유효성 검사
        String postId = member.getId();
        String postEmail = member.getEmail();

        Member verificationMember = memberRepository.findByIdOrAndEmail(postId, postEmail);
        if(verificationMember != null ) {
            if(verificationMember.getId().equals(postId) || verificationMember.getEmail().equals(postEmail)) {
                throw new ApiException("PostMultipleError", "id 및 email 중복 에러");
            }
        }

        return memberRepository.save(member);
    }

   @Transactional
    public Member modifyNameByName(Member member) {
        Member originMember = memberRepository.findOne(member.getNo());

        BeanUtils.copyProperties(member, originMember, IGNORE_FIELD_WHEN_MODIFY);
        return member;
    }

    public void modifyAuthenticationSuccess(Member originMember) {

        Point point = new Point();
        point.setPoint((long) 10);
        point.setType("member_login");
        point.setMemberNo(originMember.getNo());

        memberMapper.updateMemberPoint(point);
    }

}
