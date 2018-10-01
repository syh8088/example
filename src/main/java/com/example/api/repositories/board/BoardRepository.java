package com.example.api.repositories.board;

import com.example.api.model.entities.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, String>, BoardRepositoryCustom {


}
