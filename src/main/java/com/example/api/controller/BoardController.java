package com.example.api.controller;


import com.example.api.entities.Board;
import com.example.api.entities.BoardAndBoardList;
import com.example.api.entities.BoardList;
import com.example.api.service.BoardService;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {
    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/members/{boardId}")
    public ResponseEntity<BoardAndBoardList> getMember(@PathVariable("boardId") String boardId) {
        return ResponseEntity.ok().body(boardService.getBoard(boardId));
    }


    @GetMapping("/members/create/{boardId}")
    public void setMember(
            @PathVariable("boardId") String boardId

    ) {
// @RequestBody CreatePostRequest request
        BoardList boardList = new BoardList();
        boardList.setBoardId(boardId);
      //  boardList.setSubject(request.getSubject());
      //  boardList.setContent(request.getContent());

        boardService.setBoard(boardList);


        //return ResponseEntity.ok().body(boardService.setBoard(boardList));
    }

    @NoArgsConstructor
    @Data
    @JsonPropertyOrder({"category", "title", "content"})
    private static class CreatePostRequest {

        private String category;
        private String subject;
        private String content;

    }


}
