package com.example.api.repositories;

import com.example.api.entities.Board;
import com.example.api.entities.BoardList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {
    Board getBoard(String boardId);

    // TODO @Param으로 하면 문제없다 왜?
    List<BoardList> getBoardList(@Param("boardId") String boardId);

    BoardList getOneBoard(BoardList boardList);

    int setHitBoard(BoardList boardList);

    int setBoard(BoardList boardList);

    int updateBoardParentId(BoardList boardList);

    int getBoardLimitWriteCount(@Param("boardId") String boardId);

    int updateBoard(BoardList boardList);

    int delBoard(@Param("boardId") String boardId, @Param("postId") int postId);

    int setBoardComment(BoardList boardList);
}
