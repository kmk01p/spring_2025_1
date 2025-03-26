package com.example.spring20251.controller;

import com.example.spring20251.service.NoticeService;
import com.example.spring20251.service.impl.NoticeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/notice")
@RestController
public class NoticeRestController {

    //생성자방식: 생성자가 직접 주입하는 방식
    NoticeService noticeService;
    NoticeRestController(NoticeService noticeService){
        this.noticeService = noticeService;
    }

    @GetMapping("/create")
    public int create(@RequestParam String title, String content, @RequestParam String author) { //? 이렇게 하면 url에 직접입력할 때, 순서 어떻게 해야 되는지
        int resultCode = noticeService.create(title, content, author);
        return resultCode;
    }

    @GetMapping("/list")
    public List<Map<String, Object>> list(String title, String author) {
        List<Map<String, Object>> resultData = noticeService.list(title, author);
        return resultData;
    }
}
