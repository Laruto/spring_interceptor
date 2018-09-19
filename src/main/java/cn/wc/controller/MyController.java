package cn.wc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello controller");
        return "index.jsp";
    }
}
