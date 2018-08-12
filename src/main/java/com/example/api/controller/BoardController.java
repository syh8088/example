package com.example.api.controller;


import com.example.api.entities.board.BoardAndBoardList;
import com.example.api.entities.board.BoardList;
import com.example.api.service.BoardService;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    //@GetMapping("/members/create/{boardId}/{subject}/{content}")
    @PostMapping("/members/create/{boardId}")
    public ResponseEntity<BoardList> setMember (
            @PathVariable("boardId") String boardId,
            @RequestBody CreatePostRequest request
    ) throws Exception {
        BoardList boardList = new BoardList();
        boardList.setBoardId(boardId);
        boardList.setSubject(request.subject);
        boardList.setContent(request.content);

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

    // 댓글 쓰기
    @GetMapping("/members/create/comment/{boardId}/{postId}/{content}")
    public ResponseEntity<BoardList> setMemberComment(
            @PathVariable("boardId") String boardId,
            @PathVariable("postId") int postId,
            @PathVariable("content") String content

    ) {
        BoardList boardList = new BoardList();
        boardList.setBoardId(boardId);
        boardList.setId(postId);
        boardList.setContent(content);

        return ResponseEntity.ok().body(boardService.setBoardComment(boardList));
    }

    @NoArgsConstructor
    @Data
    @JsonPropertyOrder({"subject", "content"})
    private static class CreatePostRequest {

        private String subject;
        private String content;

    }


}
