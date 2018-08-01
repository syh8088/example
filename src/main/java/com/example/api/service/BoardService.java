package com.example.api.service;

import com.example.api.entities.Board;
import com.example.api.entities.BoardAndBoardList;
import com.example.api.entities.BoardList;
import com.example.api.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        int limitWrite = board.getLimitWrite();


        int postId = boardRepository.setBoard(boardList);

    }

}
