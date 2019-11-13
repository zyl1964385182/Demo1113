package com.shop.web;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
        @RequestMapping(value = "/login")
    public String login(HttpServletRequest request) throws Exception {
        String s = request.getParameter("shiroLoginFailure");
        if (s!=null){
            //判断具体是什么错误
            //判断用户名错误
            if (UnknownAccountException.class.getName().equals(s)){
                throw new Exception("账号不存在");
            }else if(IncorrectCredentialsException.class.getName().equals(s)){
                throw  new Exception("用户名或者密码不正确");
            }else {
                throw new Exception();
            }
        }
        //此方法不处理登录成功，shiro认证成功，会自动跳转到上一个路径！index.jsp
        //在该方法中不需要处理登录成功的处理
        return "login";

    }
}
