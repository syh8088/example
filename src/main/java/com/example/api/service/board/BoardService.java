package com.example.api.service.board;

import com.example.api.exception.BaseException;
import com.example.api.model.entities.board.Board;
import com.example.api.model.entities.board.BoardAndBoardList;
import com.example.api.model.entities.board.BoardList;
import com.example.api.model.entities.member.Member;
import com.example.api.model.entities.point.Point;
import com.example.api.repositories.board.BoardMapper;
import com.example.api.repositories.board.BoardRepository;
import com.example.api.repositories.member.MemberMapper;
import com.example.api.repositories.member.MemberRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.List;

@Service
public class BoardService {

    private BoardMapper boardMapper;
    private BoardRepository boardRepository; // JPA
    private MemberRepository memberRepository;
    private MemberMapper memberMapper;

    @Autowired
    public BoardService(BoardMapper boardMapper, BoardRepository boardRepository, MemberRepository memberRepository, MemberMapper memberMapper) {
        this.boardMapper = boardMapper;
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    public BoardAndBoardList getBoard(BoardList boardList) {

        BoardAndBoardList boardAndBoardLists = new BoardAndBoardList();

        // 마이바티스
        //Board board = boardMapper.getBoard(boardList.getBoardId());

        // JPA
        //Board board = boardRepository.findById(boardList.getBoardId()).get();

        // queryDSL
        Board board = boardRepository.getBoardById(boardList.getBoardId());

        List<BoardList> newBoardList = boardMapper.getBoardList(boardList.getBoardId());

        boardAndBoardLists.setBoard(board);
        boardAndBoardLists.setBoardList(newBoardList);

        return boardAndBoardLists;
    }

    public BoardList getOneBoard(BoardList boardList) {

        Board board = boardMapper.getBoard(boardList.getBoardId());
        int hit = boardMapper.setHitBoard(boardList);

        BoardList newBoardList = boardMapper.getOneBoard(boardList);

        return newBoardList;
    }

    @Transactional
    public BoardList setBoard(BoardList boardList, HttpServletRequest httpServletRequestequest) throws BaseException {

        String subject = boardList.getSubject();
        String content = boardList.getContent();
        String boardId = boardList.getBoardId();

        Board board = boardMapper.getBoard(boardId);

        // 하루 글쓰기 제한 유효성 검사
        int limitWrite = board.getLimitWrite();
        if(limitWrite > 0) {
            int limitWriteCount = boardMapper.getBoardLimitWriteCount(boardId);
            if(limitWriteCount > limitWrite) {
                throw new BaseException("PostPermissionDeniedError", "게시판은 하루 " + limitWrite + "회 글쓰기가 가능합니다.");
            }
        }

        // 내용 최소 글수 제한
        if(content.length() < board.getWriteMin()) {
            throw new BaseException("WriteMinError", "내용 글수 최저 글수 제한");
        } else if(content.length() > board.getWriteMax()) {  // 내용 최대 글수 제한
            throw new BaseException("WriteMaxError", "내용 글수 최대 글수 제한");
        }

        int attachmentsCount = StringUtils.countMatches(content, "<img");

        // TODO 데이터 타입인 boolean은 셋터 겟터 사용못하나?
        //boardList.isPhoto();
        if(attachmentsCount > 0) boardList.setPhoto(true);

        // ip 등록
        try {
            InetAddress local = InetAddress.getLocalHost();
            String ip = local.getHostAddress();
            boardList.setIp(ip);
        } catch (Exception e) {
            System.out.println("InetAddress ERROR");
        }

        // TODO 리턴값이 CREATE 한 id값으로 오는게 아니라 도메인 boardList에 자동 저장되는가??
        boardList.setCreateBy((String) httpServletRequestequest.getSession().getAttribute("userId"));
        boardMapper.setBoard(boardList);
        boardMapper.updateBoardParentId(boardList);

        // 게시물 등록시 포인트 지급
        if(board.getWritePoint() > 0) {
            Member member = memberRepository.getMemberById((String) httpServletRequestequest.getSession().getAttribute("userId"));

            Point point = new Point();
            point.setPoint(board.getWritePoint());
            point.setType("board_create");
            point.setMemberNo(member.getMemberNo());
            memberMapper.updateMemberPoint(point);
        }

        return getOneBoard(boardList);
    }

    public BoardAndBoardList updateBoard(BoardList boardList, HttpServletRequest httpServletRequestequest) throws BaseException {

        String boardId = boardList.getBoardId();
        String content = boardList.getContent();
        Board board = boardMapper.getBoard(boardId);

        // ip 등록
        try {
            InetAddress local = InetAddress.getLocalHost();
            String ip = local.getHostAddress();
            boardList.setIp(ip);
        }catch (Exception e) {
            throw new BaseException("InetAddressError", "IP 등록 에러");
        }

        int countModify = board.getCountModify();
        if(countModify == 1) {
            throw new BaseException("WongeulNotCrystalError", "원글 수정 불가능");
        }

        // 내용 최소 글수 제한
        if(content.length() < board.getWriteMin()) {
            throw new BaseException("WriteMinError", "내용 글수 최저 글수 제한");
        } else if(content.length() > board.getWriteMax()) {  // 내용 최대 글수 제한
            throw new BaseException("WriteMaxError", "내용 글수 최대 글수 제한");
        }

        boardList.setUpdateBy((String) httpServletRequestequest.getSession().getAttribute("userId"));
        boardMapper.updateBoard(boardList);
        return this.getBoard(boardList);
    }

    public void delBoard(String boardId, int postId) throws BaseException {

        Board board = boardMapper.getBoard(boardId);

        int countDelete = board.getCountDelete();
        if(countDelete == 1) {
            // TODO 글삭제 불가능 조건 처리
            throw new BaseException("CountDeleteError", "원글 삭제 불가능");
        }

        boardMapper.delBoard(boardId, postId);
    }

    public BoardList setBoardComment(BoardList boardList) {

        long id = boardList.getId();
        String content = boardList.getContent();
        String boardId = boardList.getBoardId();

        Board board = boardMapper.getBoard(boardId);

        // ip 등록
        try {
            InetAddress local = InetAddress.getLocalHost();
            String ip = local.getHostAddress();
            boardList.setIp(ip);
        }catch (Exception e) {
            System.out.println("InetAddress ERROR");
        }

        int postId = boardMapper.setBoardComment(boardList);
        return getOneBoard(boardList);
    }

    @Transactional
    public Board getBoard(String boardId) {
        return boardMapper.getBoard(boardId);
    }

    @Transactional
    public int getBoardLimitWriteCount(String boardId) {
        return boardMapper.getBoardLimitWriteCount(boardId);
    }

}
