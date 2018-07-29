package com.example.api.entities;

import lombok.Data;

import java.util.List;

@Data
public class BoardAndBoardList {

    private Board board;
    private List<BoardList> boardList;

}
