package com.example.spring20251.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/board/")
@RestController
public class BoardRestController {

    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam String title, @RequestParam String content,@RequestParam Integer
            order){
        System.out.println("title : " + title + ", content : " + content);
        int resultCode = 0;


        Map<String, Object> board = new HashMap<>();
        board.put("order", order);
        board.put("title", title);
        board.put("content", content);

        list.add(board);

        System.out.println("list : " + list.size());
        resultCode = 200;

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", resultCode);
        resultMap.put("order", order);
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

    @GetMapping("/update/{order}")
    public Map<String, Object> update(@PathVariable("order") int order, @RequestParam Map<String, Object> param){
        int resultCode = 0;
        resultCode = 200;

        Map<String, Object> board = list.get(order - 1);

        String title = param.get("title").toString();
        if(title != null){
            board.put("title", title);
        }

        String content = param.get("content").toString();
        if(content != null){
            board.put("content", content);
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", resultCode);
        resultMap.put("data", board);
        return resultMap;
    }

    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam int order){
        int resultCode = 0;
        resultCode = 200;

        Map<String, Object> board = list.get(order - 1);

        //순서, 지워져있는 것처럼
        board.remove("order");
        board.remove("title");
        board.remove("content");

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", resultCode);
        resultMap.put("data", board);
        return resultMap;
    }

    @GetMapping("/detail/{order}")
    public Map<String, Object> detail(@PathVariable("order") int order){
        int resultCode = 0;
        resultCode = 200;

        Map<String, Object> board = list.get(order - 1);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", resultCode);
        resultMap.put("data", board);
        return resultMap;
    }
}
