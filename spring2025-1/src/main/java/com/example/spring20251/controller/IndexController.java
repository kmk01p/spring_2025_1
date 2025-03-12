package com.example.spring20251.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    //test -> test return
    @RequestMapping("/test1")
    @ResponseBody
    public String test(){
        return "test1";
    }

    //map
    @RequestMapping("/map")
    @ResponseBody
    public Map<String, Object> map(){
        Map<String, Object> map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        return map;
    }

    //list
    @RequestMapping("/list")
    @ResponseBody
    public List<String> list(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.remove(2);
        return list;
    }

}
