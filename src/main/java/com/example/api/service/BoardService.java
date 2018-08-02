package com.example.api.service;

import com.example.api.entities.Board;
import com.example.api.entities.BoardAndBoardList;
import com.example.api.entities.BoardList;
import com.example.api.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardAndBoardList getBoard(String boardId) {

        BoardAndBoardList boardAndBoardLists = new BoardAndBoardList();

        Board board = boardRepository.getBoard(boardId);
        List<BoardList> boardList = boardRepository.getBoardList(boardId);

        boardAndBoardLists.setBoard(board);
        boardAndBoardLists.setBoardList(boardList);

        return boardAndBoardLists;
    }

    public void setBoard(BoardList boardList) {

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






        //int postId = boardRepository.setBoard(boardList);

    }

}
