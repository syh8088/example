package com.example.api.service;

import com.example.api.entities.Board;
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

    public BoardList getBoard(String boardId) {

      //  Board board = boardRepository.selectBy(boardId);
      //  BoardList boardLists = new BoardList();
      //  boardLists.setBoard(board);

        BoardList boardList = boardRepository.boardList(boardId);

        return boardList;
       // return
    }

}
