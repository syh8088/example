package com.example.api.service;

import com.example.api.ApiException;
import com.example.api.entities.board.Board;
import com.example.api.entities.board.BoardAndBoardList;
import com.example.api.entities.board.BoardList;
import com.example.api.entities.point.Point;
import com.example.api.repositories.board.BoardMapper;
import com.example.api.repositories.board.BoardRepository;
import com.example.api.repositories.point.PointRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.net.InetAddress;
import java.util.List;

@Service
public class BoardService {

    private BoardMapper boardMapper;
    private BoardRepository boardRepository; // JPA
    private PointRepository pointRepository; // JPA

    @Autowired
    public BoardService(BoardMapper boardMapper, BoardRepository boardRepository, PointRepository pointRepository) {
        this.boardMapper = boardMapper;
        this.boardRepository = boardRepository;
        this.pointRepository = pointRepository;
    }

    public BoardAndBoardList getBoard(BoardList boardList) {

        BoardAndBoardList boardAndBoardLists = new BoardAndBoardList();

        // 마이바티스
        //Board board = boardMapper.getBoard(boardList.getBoardId());

        // JPA
        //Board board = boardRepository.findById(boardList.getBoardId()).get();

        // queryDSL
        Board board = boardRepository.getBoardById(boardList.getBoardId());

/*
        Optional<Board> board1 = Optional.of(new Board());
        board1.orElse(new Board());
        */

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

    public BoardList setBoard(BoardList boardList) throws ApiException {

        String subject = boardList.getSubject();
        String content = boardList.getContent();
        String boardId = boardList.getBoardId();

        Board board = boardMapper.getBoard(boardId);

        // 하루 글쓰기 제한 유효성 검사
        int limitWrite = board.getLimitWrite();
        if(limitWrite > 0) {
            int limitWriteCount = boardMapper.getBoardLimitWriteCount(boardId);
            if(limitWriteCount > limitWrite) {
                throw new ApiException("PostPermissionDeniedError", "게시판은 하루 " + limitWrite + "회 글쓰기가 가능합니다.");
            }
        }

        // 내용 최소 글수 제한
        if(content.length() < board.getWriteMin()) {
            throw new ApiException("WriteMinError", "내용 글수 최저 글수 제한");
        } else if(content.length() > board.getWriteMax()) {  // 내용 최대 글수 제한
            throw new ApiException("WriteMaxError", "내용 글수 최대 글수 제한");
        }

        int attachmentsCount = StringUtils.countMatches(content, "<img");

        // TODO 데이터 타입인 boolean은 셋터 겟터 사용못하나?
        //boardList.isPhoto();
        if(attachmentsCount > 0) boardList.setPhoto(true);

/*        Elements imgs = Jsoup.parseBodyFragment(content).select("img");
        System.out.println(imgs);
        for (Element img : imgs) {
            System.out.println(img);

        }*/

        // ip 등록
        try {
            InetAddress local = InetAddress.getLocalHost();
            String ip = local.getHostAddress();
            boardList.setIp(ip);
        } catch (Exception e) {
            System.out.println("InetAddress ERROR");
        }

        // TODO 리턴값이 CREATE 한 id값으로 오는게 아니라 도메인 boardList에 자동 저장되는가??
        boardMapper.setBoard(boardList);
        boardMapper.updateBoardParentId(boardList);

        // 게시물 등록시 포인트 지급
        if(board.getWritePoint() > 0) {
            Point point = new Point();
            point.setPoint(board.getWritePoint());
            point.setType("board_create");
            point.setMemberId(boardList.getId());
            pointRepository.save(point);
        }

        return getOneBoard(boardList);
    }

    public BoardAndBoardList updateBoard(BoardList boardList) {


        String boardId = boardList.getBoardId();
        String content = boardList.getContent();
        Board board = boardMapper.getBoard(boardId);

        // ip 등록
        try {
            InetAddress local = InetAddress.getLocalHost();
            String ip = local.getHostAddress();
            boardList.setIp(ip);
        }catch (Exception e) {
            System.out.println("InetAddress ERROR");
        }

        int countModify = board.getCountModify();
        System.out.println(countModify);
        if(countModify == 1) {

            // TODO 글수정 불가능 조건 처리
        }

        // 내용 최소 글수 제한
        if(content.length() < board.getWriteMin()) {

        } else if(content.length() > board.getWriteMax()) {  // 내용 최대 글수 제한

        }

        boardMapper.updateBoard(boardList);
        return this.getBoard(boardList);
    }

    public void delBoard(String boardId, int postId) {

        Board board = boardMapper.getBoard(boardId);

        int countDelete = board.getCountDelete();
        System.out.println(countDelete);
        if(countDelete == 1) {
            // TODO 글삭제 불가능 조건 처리

        }

        // TODO 성공 및 실패시 리턴값을 어떻게 받지??
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


}
