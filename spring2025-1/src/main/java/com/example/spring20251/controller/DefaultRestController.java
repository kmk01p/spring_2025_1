package com.example.spring20251.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api") //모든 메서드에 공통적으로 앞에 붙는 주소값을 넣어줄 수 있습니다!!
@RestController
public class DefaultRestController {

    @GetMapping("/test")
    public Map<String, Object> test(int a, int b){
        System.out.println("a : " + a);
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("data", "hahaha");
        return map;
    }
    @GetMapping("/abc")
    public Map<String, Object> abc(){
        return null;
    }
    @GetMapping("/multiple")
    public Map<String, Object> multi(int a, int b){
        Map<String, Object> multimap = new HashMap<>();
        int multi = a*b;
        multimap.put("multiple", multi);
        return multimap;
    }

    @GetMapping("/login")
    public Map<String, Object> logmap(String id, String pw){
        int resultCode = 0;
        if("1234".equals(id)&&"1111".equals(pw)){
            resultCode =200;
        }
        Map<String, Object> logmap = new HashMap<>();
        logmap.put("resultCode", resultCode);
        return logmap;
    }
}

//controller 사용해서 조회, 생성, 업데이트하기