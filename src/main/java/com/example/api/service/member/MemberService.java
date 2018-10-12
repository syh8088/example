package com.example.api.service.member;

import com.example.api.model.entities.member.Member;
import com.example.api.model.entities.point.Point;
import com.example.api.exception.ApiException;
import com.example.api.model.enums.OauthType;
import com.example.api.repositories.member.MemberCrudRepository;
import com.example.api.repositories.member.MemberMapper;
import com.example.api.repositories.member.MemberRepository;
import com.example.api.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MemberService {

    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;
    private final MemberCrudRepository memberCrudRepository;
    private final SessionFactory sessionFactory;

    private static final String IGNORE_FIELD_WHEN_MODIFY[] = {Constants.DELETE_YN, Constants.REGISTER_YMDT, Constants.UPDATE_YMDT, Constants.EMAIL, Constants.ID, Constants.NO};

    @Autowired
    public MemberService(MemberMapper memberMapper, MemberRepository memberRepository, MemberCrudRepository memberCrudRepository, SessionFactory sessionFactory) {
        this.memberMapper = memberMapper;
        this.memberRepository = memberRepository;
        this.memberCrudRepository = memberCrudRepository;
        this.sessionFactory = sessionFactory;
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
            case "All":
                member = (Member) memberRepository.findAll();
                System.out.println(member);
                break;
            default:
                //member = memberCrudRepository.findOne(no);

                Point point = new Point();
                point.setPoint(100);
                point.setType("test");
                point.setMemberNo(1);

                Session session = sessionFactory.openSession();
                session.beginTransaction();
                session.save(point);
                session.getTransaction().commit();


                //System.out.println(member);
                member = memberMapper.selectById(no);
        }
        return member;
    }

    public Member getMemberById(String userId) {
        return memberRepository.getMemberById(userId);
    }

    public Member saveSomethingMember(Member member) {
/*

        // id, email 중복 유효성 검사
        String postId = member.getId();
        String postEmail = member.getEmail();

        Member verificationMember = memberRepository.findByIdOrAndEmail(postId, postEmail);
        if(verificationMember != null ) {
            if(verificationMember.getId().equals(postId) || verificationMember.getEmail().equals(postEmail)) {
                throw new ApiException("PostMultipleError", "id 및 email 중복 에러");
            }
        }
*/

        return memberRepository.save(member);
    }

    @Transactional
    public Member saveTransactionPropagationTest(Member member) {
        return memberRepository.save(member);
    }

    @Transactional
    public Member modifyNameByName(Member member) {
        Member originMember = memberRepository.findOne(member.getNo());

        BeanUtils.copyProperties(member, originMember, IGNORE_FIELD_WHEN_MODIFY);
        return member;
    }

    @Transactional
    public void savePoint(int point, String type, long memberNo) {
        Point newPoint = new Point();
        newPoint.setPoint(point);
        newPoint.setType(type);
        newPoint.setMemberNo(memberNo);

        memberMapper.updateMemberPoint(newPoint);
    }

    @Transactional
    public Member getMemberByOauthTypeAndId(OauthType type, String id) {
        Member member = memberRepository.findByOauthTypeAndOauthId(type, id);
        return member;
    }

    public boolean isAlreadyRegisteredId(String id) {
        return memberRepository.findById(id) != null;
    }
}
