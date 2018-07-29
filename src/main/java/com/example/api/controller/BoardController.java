package com.example.api.controller;


import com.example.api.entities.Board;
import com.example.api.entities.BoardList;
import com.example.api.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/members/{boardId}")
    public ResponseEntity<BoardList> getMember(@PathVariable("boardId") String boardId) {
        //System.out.println(boardId);
        return ResponseEntity.ok().body(boardService.getBoard(boardId));
    }


}
