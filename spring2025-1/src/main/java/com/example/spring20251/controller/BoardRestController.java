package com.example.spring20251.controller;

import com.example.spring20251.domain.Board;
import com.example.spring20251.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/board")
@RestController
public class BoardRestController {

    final BoardService boardService;
    public BoardRestController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/create")
    public Long create(@RequestParam Map<String, Object> param){
        System.out.println("title : " + param.get("title"));
        return boardService.create(param);
    }

    @GetMapping("/list")
    public List<Board> list(){
        return boardService.list();
    }

    @GetMapping("/detail")
    public Board detail(@RequestParam Long id){
        return boardService.detail(id);
    }

    @GetMapping("/update/{id}")
    public Board update(@PathVariable("id") Long id,@RequestParam Map<String,Object> param) {
        return boardService.update(id, param);

    }

    @GetMapping("/delete/{id}")
    public Board delete(@PathVariable("id") Long id){
        return boardService.delete(id);
    }

}