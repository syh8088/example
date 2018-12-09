package com.example.api.util.validator;

import com.example.api.error.errorCode.BoardErrorCode;
import com.example.api.error.errorCode.MemberErrorCode;
import com.example.api.error.exception.BoardException;
import com.example.api.error.exception.MemberException;
import com.example.api.model.entities.board.Board;
import com.example.api.model.entities.board.BoardList;
import com.example.api.model.request.MemberRequest;
import com.example.api.service.board.BoardService;
import com.example.api.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    private MemberService memberService;
    private BoardService boardService;

    @Autowired
    public Validator(MemberService memberService, BoardService boardService) {
        this.memberService = memberService;
        this.boardService = boardService;
    }

    public void member(MemberRequest memberRequest) {

        if (memberRequest.getPassword().length() < 10) {
            throw new MemberException(MemberErrorCode.NOT_VALID_PASSWORD_LENGTH);
        }

        if (memberService.isAlreadyRegisteredId(memberRequest.getId())) {
            throw new MemberException(MemberErrorCode.ALREADY_JOIN_ID);
        }
    }

    public void isRegisteredBoardId(String boardId) {
        Board board = boardService.getBoard(boardId);
        if(board == null) {
            throw new BoardException(BoardErrorCode.NOT_EXIST_BOARD);
        }
    }

    public void setBaord(BoardList boardList) {
        Board board = boardService.getBoard(boardList.getBoardId());

        // 하루 글쓰기 제한 유효성 검사
        int limitWrite = board.getLimitWrite();
        if(limitWrite > 0) {

            int limitWriteCount = boardService.getBoardLimitWriteCount(boardList.getBoardId());
            if(limitWriteCount > limitWrite) {
                throw new BoardException(BoardErrorCode.NOT_LIMIT_WRITE_COUNT, limitWrite);
            }
        }


    }

}
