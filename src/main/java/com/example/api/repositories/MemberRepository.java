package com.example.api.repositories;

import com.example.api.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Board, String> {



}
