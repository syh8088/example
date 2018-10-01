package com.example.api.repositories.cast;

import com.example.api.model.entities.cast.CastContents;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CastMapper {
    List<CastContents> getCastLists();

}
