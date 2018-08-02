package com.example.api.repositories;

import com.example.api.entities.Board;
import com.example.api.entities.BoardList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardRepository {
    Board getBoard(String boardId);

    // TODO @Param으로 하면 문제없다 왜?
    List<BoardList> getBoardList(@Param("boardId") String boardId);



    int setBoard(BoardList boardList);


    int getBoardLimitWriteCount(@Param("boardId") String boardId);
}
