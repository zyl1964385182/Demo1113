package com.shop.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(value = "/index")
    public String index(Model model){
        //获得subject主体
        Subject subject = SecurityUtils.getSubject();
        //根据subject主体就可以的到身份信息（userName）
        String username = subject.getPrincipal().toString();
        model.addAttribute("username",username);
        return "index";
    }
}
