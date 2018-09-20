package cn.wc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MyController {

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password){
        System.out.println("-----login-----");
        if(username.equals("wc")&&password.equals("1234")){
            session.setAttribute("username",username);
            session.setAttribute("passward",password);
            return "hello";
        }
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) throws Exception {
        // 清除Session
        session.invalidate();

        return "hello";
    }
}
