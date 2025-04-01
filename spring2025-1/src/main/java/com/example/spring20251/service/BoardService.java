package com.example.spring20251.service;

import com.example.spring20251.domain.Board;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BoardService {
    Long create(Map<String, Object> param);
    List<Board> list();
    Board detail(Long id);
    Board update(Long id, Map<String, Object> param);
    Board delete(Long id);
}
