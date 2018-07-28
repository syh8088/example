package com.example.api.repositories;

import com.example.api.entities.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardRepository {
    Board selectById(long no);
}
