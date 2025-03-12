package com.example.spring20251.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/index") //주소 -> /index라는 주소로 가면 String 리턴
    @ResponseBody //페이지를 리텅해줘야 하는데, JSON 형태로 리턴해주기 위한 코드 -> 컨트롤러가 찾아가는 주소
    public String index() {
        return "index";
    }


    //@RequestMapping: request를 mapping하는 method
    //@ResponseBody: page이동


    @RequestMapping("/abc")
    @ResponseBody
    public Map<String, Object> abc() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("11","abc");
        return map;
    }

    //일반 컨트롤러이고, 페이지를 리턴
    @RequestMapping("/page1") //thymeleaf
    public String page() {
        return "sum";
    }
}
