package com.example.spring20251.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/notice")
@Controller //spring에 꼭 필요한 컴포넌트
public class NoticeController {

//    @GetMapping("/create")
//    public String create(){
//        return "create";
//    }
//
//    @GetMapping("/update")
//    public String update(){
//        return "update";
//    }

    @GetMapping("/{page}") //get 방식만 받고, url로 치고 들어오는 mapping 방식
    public String page(@PathVariable String page){
        return "notice/" +page;
    }

    @GetMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id){
        return "notice/" +page;
    }
}
