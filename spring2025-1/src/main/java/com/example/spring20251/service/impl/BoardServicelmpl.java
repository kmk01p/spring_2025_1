package com.example.spring20251.service.impl;

import com.example.spring20251.domain.Board;
import com.example.spring20251.repository.BoardRepository;
import com.example.spring20251.service.BoardService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Service
public class BoardServicelmpl implements BoardService {

    final BoardRepository boardRepository;

    public BoardServicelmpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Long create(Map<String, Object> param) {
        String title = (String) param.get("title");
        String content = (String) param.get("content");
        String author = (String) param.get("author");

        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setAuthor(author);

        boardRepository.save(board);

        return board.getId();
    }

    @Override
    public List<Board> list() {
        List<Board> list = boardRepository.findAll();
        return list;
    }

    @Override
    public Board detail(Long id) {
        //Optional<Board> board = boardRepository.findById(id);
        Board board = boardRepository.findById(id).orElse(null);
        return board;
    }

    @Override
    public Board update(Long id, Map<String, Object> param) {
        Board board = boardRepository.findById(Long.valueOf(param.get("id").toString())).orElse(null);
        if (param.get("title") != null) {
            board.setTitle(param.get("title").toString());
        }
        if (param.get("content") != null) {
            board.setContent(param.get("content").toString());
        }

        // 저장 후 반환
        boardRepository.save(board);
        return board;
    }



    @Override
    public Board delete(Long id) {
        Board board = boardRepository.findById(id).orElse(null);
        return board;
    }


}