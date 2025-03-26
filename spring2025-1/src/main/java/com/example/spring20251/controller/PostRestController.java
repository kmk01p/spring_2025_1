package com.example.spring20251.controller;

import com.example.spring20251.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/post")
@RestController
public class PostRestController {

    /*
    @Autowired
    PostService postService;
    */

    //생성자 방식
    private final PostService postService;
    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam String title, @RequestParam String content){
        Map<String, Object> param = new HashMap<>();
        param.put("title", title);
        param.put("content", content);

        Map<String, Object> resultMap = postService.create(param);
        return resultMap;
    }

    @GetMapping("/update/{order}")
    public Map<String, Object> update(@PathVariable("order") int order
            , @RequestParam Map<String, Object> param){
        Map<String, Object> resultMap = postService.update(order, param);
        return resultMap;
    }
    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam int order){
        Map<String, Object> resultMap = postService.delete(order);
        return resultMap;
    }

    @GetMapping("/list")
    public List<Map<String, Object>> list(){
        List<Map<String, Object>> resultList = postService.list();
        return resultList;
    }
    @GetMapping("/detail/{order}")
    public Map<String, Object> detail(@PathVariable("order") int order){
        Map<String, Object> resultMap = postService.detail(order);
        return resultMap;
    }
}
