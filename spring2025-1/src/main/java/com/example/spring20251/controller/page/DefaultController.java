package com.example.spring20251.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller //page controller인 경우 그냥 controller
public class DefaultController {

    @RequestMapping({"","/","/index"}) //스트링 한개 가능
    public String index() {
        return "index";
    }

    @RequestMapping("/sum")
    public Model sum(@RequestParam int a, @RequestParam int b, @RequestParam String name, Model model){
        //@RequestParam 어노테이션이 붙은 파라미터인 경우에는 없으면 에러납니다..
        int sum = a + b;
        model.addAttribute("sum", sum);
        List<String> list = new ArrayList<>();
        list.add(name);
        list.add("soo");
        model.addAttribute("name", list);
        return model;
    }

    @RequestMapping("/sum1")
    public String sum1(@RequestParam int a, @RequestParam int b, @RequestParam String name, Model model){
        int sum = 0;
        sum = a + b;
        model.addAttribute("sum", sum);
        model.addAttribute("name", name);
        return "sum1";
    }

    @RequestMapping({"/test"}) //스트링 한개 가능
    public String test() {
        int a = 0;
        double b = 0.0;
        boolean c = true;
        String d = "";

        int sum = 0;
        for (int i=0;i<10;i++) {
            sum += i;
        }
        System.out.println("sum: " + sum);

        int sum1 = 0;
        int j=0;
        while(j<10){
            sum1 += j;
            j++;
        }
        System.out.println("sum1: " + sum1);

        /*
        Map
        map.put
        map.remove
        map.get
         */

        /*
        List
        list.add
        list.remove
        list.get
         */

        /*
        for each 문 list, array
         */

        /*
        model
        model.addAttribute 에 model, class들어감
         */
        return "sum";
    }

}
