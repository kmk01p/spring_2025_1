package com.example.spring20251.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/calcu")
@RestController
public class CalcuRestController {

    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    @GetMapping("/sum")
    public Integer sum(@RequestParam Integer
            num1, @RequestParam Integer
            num2){
        int sum = num1 + num2;
        return sum;
    }
    @GetMapping("/multi")
    public Integer multi(@RequestParam Integer
                                  num1, @RequestParam Integer
                                  num2){
        int multi = num1 * num2;
        return multi;
    }

}
