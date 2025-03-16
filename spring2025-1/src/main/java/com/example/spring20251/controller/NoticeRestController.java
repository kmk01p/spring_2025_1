package com.example.spring20251.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/notice")
@RestController
public class NoticeRestController {

    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam String title, @RequestParam String content,@RequestParam Integer
            id, @RequestParam String author){
        int resultCode = 0;

        Map<String, Object> notice = new HashMap<>();
        notice.put("id", id);
        notice.put("title", title);
        notice.put("content", content);
        notice.put("author", author);

        list.add(notice);

        System.out.println("list : " + list.size());
        resultCode = 200;

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", resultCode);
        resultMap.put("order", id);
        return resultMap;
    }
    @GetMapping("/list")
    public Map<String, Object> list(){
        int resultCode = 0;
        resultCode = 200;

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", resultCode);
        resultMap.put("data", list);
        return resultMap;
    }
    @GetMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable("id") int id){
        int resultCode = 0;
        resultCode = 200;

        Map<String, Object> board = list.get(id - 1);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", resultCode);
        resultMap.put("data", board);
        return resultMap;
    }
}
