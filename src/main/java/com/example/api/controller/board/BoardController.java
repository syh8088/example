package com.example.api.controller.board;


import com.example.api.entities.board.BoardAndBoardList;
import com.example.api.entities.board.BoardList;
import com.example.api.service.board.BoardService;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("boards")
@Api(tags = "Board")
public class BoardController {
    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 글읽기
    @GetMapping("{boardId}")
    @ApiOperation(value = "Get board into type", notes = "Returns the board of the type")
    public ResponseEntity<BoardAndBoardList> getMember(@PathVariable("boardId") @ApiParam(value = "Board id") String boardId) {

        BoardList boardList = new BoardList();
        boardList.setBoardId(boardId);

        return ResponseEntity.ok().body(boardService.getBoard(boardList));
    }

    // 해당 글읽기
    @GetMapping("boards/{boardId}/posts/{postId}")
    @ApiOperation(value = "Get board into type", notes = "Returns the board of the type")
    public ResponseEntity<BoardList> getOneMember(@PathVariable("boardId") String boardId, @PathVariable("postId") int postId) {
        BoardList boardList = new BoardList();
        boardList.setBoardId(boardId);
        boardList.setId(postId);

        return ResponseEntity.ok().body(boardService.getOneBoard(boardList));
    }

    // 글쓰기
    @PostMapping("create/boards/{boardId}")
    public ResponseEntity<BoardList> setMember(
            @PathVariable("boardId") String boardId,
            @RequestBody CreatePostRequest request,
            HttpServletRequest httpServletRequestequest
    ) throws Exception {
        BoardList boardList = new BoardList();
        boardList.setBoardId(boardId);
        boardList.setSubject(request.subject);
        boardList.setContent(request.content);

        return ResponseEntity.ok().body(boardService.setBoard(boardList, httpServletRequestequest));
    }

    // 글수정
    @PutMapping("update/boards/{boardId}/posts/{postId}/subject/{subject}/content/{content}")
    public ResponseEntity<BoardAndBoardList> updateMember(
            @PathVariable("boardId") String boardId,
            @PathVariable("postId") int postId,
            @PathVariable("subject") String subject,
            @PathVariable("content") String content
    ) throws Exception {
        BoardList boardList = new BoardList();
        boardList.setBoardId(boardId);
        boardList.setId(postId);
        boardList.setSubject(subject);
        boardList.setContent(content);

        return ResponseEntity.ok().body(boardService.updateBoard(boardList));
    }

    // 글삭제
    @DeleteMapping("delete/boards/{boardId}/posts/{postId}")
    public ResponseEntity<?> delMember(
            @PathVariable("boardId") String boardId,
            @PathVariable("postId") int postId
    ) throws Exception {
        boardService.delBoard(boardId, postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 댓글 쓰기
    @GetMapping("create/comment/boards/{boardId}/posts/{postId}/content/{content}")
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
