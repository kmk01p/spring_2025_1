package com.example.spring20251.repository;

import com.example.spring20251.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> { //Board: entity class, Long: pk인 id인 자료형
}
