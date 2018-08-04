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

    // 글읽기
    @GetMapping("/members/{boardId}")
    public ResponseEntity<BoardAndBoardList> getMember(@PathVariable("boardId") String boardId) {

        BoardList boardList = new BoardList();
        boardList.setBoardId(boardId);

        return ResponseEntity.ok().body(boardService.getBoard(boardList));
    }

    // 해당 글읽기
    @GetMapping("/members/{boardId}/{postId}")
    public ResponseEntity<BoardList> getOneMember(@PathVariable("boardId") String boardId, @PathVariable("postId") int postId) {
        BoardList boardList = new BoardList();
        boardList.setBoardId(boardId);
        boardList.setId(postId);

        return ResponseEntity.ok().body(boardService.getOneBoard(boardList));
    }

    // 글쓰기
    @GetMapping("/members/create/{boardId}/{subject}/{content}")
    public ResponseEntity<BoardList> setMember(
            @PathVariable("boardId") String boardId,
            @PathVariable("subject") String subject,
            @PathVariable("content") String content

    ) {
// @RequestBody CreatePostRequest request
        BoardList boardList = new BoardList();
        boardList.setBoardId(boardId);
        boardList.setSubject(subject);
        boardList.setContent(content);

        return ResponseEntity.ok().body(boardService.setBoard(boardList));
    }

    // 글수정
    @GetMapping("/members/update/{boardId}/{postId}/{subject}/{content}")
    public ResponseEntity<BoardAndBoardList> updateMember(
            @PathVariable("boardId") String boardId,
            @PathVariable("postId") int postId,
            @PathVariable("subject") String subject,
            @PathVariable("content") String content
    ) {
        BoardList boardList = new BoardList();
        boardList.setBoardId(boardId);
        boardList.setId(postId);
        boardList.setSubject(subject);
        boardList.setContent(content);

        return ResponseEntity.ok().body(boardService.updateBoard(boardList));
    }

    // 글삭제
    @GetMapping("/members/delete/{boardId}/{postId}")
    public void delMember(
        @PathVariable("boardId") String boardId,
        @PathVariable("postId") int postId
    ) {
        boardService.delBoard(boardId, postId);
        //return ResponseEntity.ok().body(boardService.delBoard(boardId, postId));
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
