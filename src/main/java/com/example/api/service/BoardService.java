package com.example.api.service;

import com.example.api.entities.Board;
import com.example.api.entities.BoardAndBoardList;
import com.example.api.entities.BoardList;
import com.example.api.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;


import java.net.InetAddress;
import java.util.List;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardAndBoardList getBoard(BoardList boardList) {

        BoardAndBoardList boardAndBoardLists = new BoardAndBoardList();

        Board board = boardRepository.getBoard(boardList.getBoardId());
        List<BoardList> newBoardList = boardRepository.getBoardList(boardList.getBoardId());

        boardAndBoardLists.setBoard(board);
        boardAndBoardLists.setBoardList(newBoardList);

        return boardAndBoardLists;
    }

    public BoardList getOneBoard(BoardList boardList) {

        Board board = boardRepository.getBoard(boardList.getBoardId());
        int hit = boardRepository.setHitBoard(boardList);

        BoardList newBoardList = boardRepository.getOneBoard(boardList);

        return newBoardList;
    }

    public BoardList setBoard(BoardList boardList) {

        String subject = boardList.getSubject();
        String content = boardList.getContent();
        String boardId = boardList.getBoardId();

        Board board = boardRepository.getBoard(boardId);

        // 하루 글쓰기 제한 유효성 검사
        int limitWrite = board.getLimitWrite();
        if(limitWrite > 0) {
            int limitWriteCount = boardRepository.getBoardLimitWriteCount(boardId);
            if(limitWriteCount > limitWrite) {
                // TODO 하루 글쓰기 초과

            }
        }

        // 내용 최소 글수 제한
        if(content.length() < board.getWriteMin()) {

        } else if(content.length() > board.getWriteMax()) {  // 내용 최대 글수 제한

        }

        int attachmentsCount = StringUtils.countMatches(content, "<img");

        // TODO 데이터 타입인 boolean은 셋터 겟터 사용못하나?
        //boardList.isPhoto();
        if(attachmentsCount > 0) boardList.setPhoto(true);

        Elements imgs = Jsoup.parseBodyFragment(content).select("img");
        System.out.println(imgs);
        for (Element img : imgs) {
            System.out.println(img);

        }

        // ip 등록
        try {
            InetAddress local = InetAddress.getLocalHost();
            String ip = local.getHostAddress();
            boardList.setIp(ip);
        }catch (Exception e) {
            System.out.println("InetAddress ERROR");
        }

        // TODO 리턴값이 CREATE 한 id값으로 오는게 아니라 도메인 boardList에 자동 저장되는가??
        System.out.println(boardList.getId());
        int postId = boardRepository.setBoard(boardList);
        boardRepository.updateBoardParentId(boardList);
        System.out.println(boardList.getId());

        //boardList.setBoardId(boardId);
        return getOneBoard(boardList);
    }

    public BoardAndBoardList updateBoard(BoardList boardList) {

        String boardId = boardList.getBoardId();
        String content = boardList.getContent();
        Board board = boardRepository.getBoard(boardId);

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

        boardRepository.updateBoard(boardList);
        return this.getBoard(boardList);
    }

    public void delBoard(String boardId, int postId) {

        Board board = boardRepository.getBoard(boardId);

        int countDelete = board.getCountDelete();
        System.out.println(countDelete);
        if(countDelete == 1) {
            // TODO 글삭제 불가능 조건 처리
        }

        // TODO 성공 및 실패시 리턴값을 어떻게 받지??
        boardRepository.delBoard(boardId, postId);
    }

    public BoardList setBoardComment(BoardList boardList) {

        long id = boardList.getId();
        String content = boardList.getContent();
        String boardId = boardList.getBoardId();

        Board board = boardRepository.getBoard(boardId);

        // ip 등록
        try {
            InetAddress local = InetAddress.getLocalHost();
            String ip = local.getHostAddress();
            boardList.setIp(ip);
        }catch (Exception e) {
            System.out.println("InetAddress ERROR");
        }

        int postId = boardRepository.setBoardComment(boardList);
        return getOneBoard(boardList);
    }


}
