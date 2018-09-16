package com.example.api.service.member;

import com.example.api.entities.member.Member;
import com.example.api.entities.point.Point;
import com.example.api.exception.ApiException;
import com.example.api.repositories.member.MemberMapper;
import com.example.api.repositories.member.MemberRepository;
import com.example.api.repositories.point.PointMapper;
import com.example.api.repositories.point.PointRepository;
import com.example.api.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Slf4j
public class MemberService {

    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;
    private final PointMapper pointMapper;
    private final PointRepository pointRepository;

    private static final String IGNORE_FIELD_WHEN_MODIFY[] = {Constants.DELETE_YN, Constants.REGISTER_YMDT, Constants.UPDATE_YMDT, Constants.EMAIL, Constants.ID, Constants.NO};

    @Autowired
    public MemberService(MemberMapper memberMapper, MemberRepository memberRepository, PointRepository pointRepository, PointMapper pointMapper) {
        this.memberMapper = memberMapper;
        this.memberRepository = memberRepository;
        this.pointRepository = pointRepository;
        this.pointMapper = pointMapper;
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

    @Transactional
    public Member modifyAuthenticationSuccess(String userId) {

        Member originMember = memberRepository.getMemberById(userId);

        Point point = new Point();
        point.setPoint((long) 10);
        point.setType("member_login");
        point.setMemberNo(originMember.getNo());
        pointRepository.save(point);

        Long sumPoint = pointMapper.getSumPoint(originMember.getNo());

        Member newMember = new Member();

        LocalDateTime dateTime = LocalDateTime.now();
        newMember.setTodayLogin(dateTime);
        newMember.setMemberGroup(originMember.getMemberGroup());
        newMember.setName(originMember.getName());
        newMember.setPassword(originMember.getPassword());
        newMember.setPoint(sumPoint);

        BeanUtils.copyProperties(newMember, originMember, IGNORE_FIELD_WHEN_MODIFY);

        return newMember;
    }

}
