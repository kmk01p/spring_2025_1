package com.example.spring20251.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/calcu")
@Controller
public class CalcuController {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return "calcu/" + page;
    }
}
