package com.example.api.repositories;

import com.example.api.entities.Board;
import com.example.api.entities.BoardList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardRepository {
    Board selectBy(String boardId);

    BoardList boardList(String boardId);
}
