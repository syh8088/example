package com.example.api.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@ToString
// @Entity  TODO 주석 풀면 에러남 왜?
public class BoardAndBoardList {

    private Board board;
    private List<BoardList> boardList;

}
