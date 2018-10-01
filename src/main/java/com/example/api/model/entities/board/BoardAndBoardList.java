package com.example.api.model.entities.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
// @Entity  TODO 주석 풀면 에러남 왜?
public class BoardAndBoardList {

    private Board board;
    private List<BoardList> boardList;

}
