package com.applewjg.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * Created by baidu on 16/4/22.
 */
@Controller
public class LoginLogoutController {

    protected static Logger logger = LoggerFactory.getLogger(LoginLogoutController.class);

    /**
     * 指向登录页面
     */
    @RequestMapping(value = "/auth/login", method = RequestMethod.GET)
    public String getLoginPage(
            @RequestParam(value = "error", required = false) boolean error,
            ModelMap model) {

        logger.info("Received request to show login page");

        if (error == true) {
            // Assign an error message
            model.put("error",
                    "You have entered an invalid username or password!");
        } else {
            model.put("error", "");
        }
        return "loginpage";

    }

    /**
     * 指定无访问额权限页面
     *
     * @return
     */
    @RequestMapping(value = "/auth/denied", method = RequestMethod.GET)
    public String getDeniedPage() {

        logger.info("Received request to show denied page");

        return "deniedpage";

    }
/*

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String getLogoutPage(
            @RequestParam(value = "error", required = false) boolean error,
            ModelMap model) {

        logger.info("Received request to show logout page");

        return "redirect:/j_spring_security_logout";

    }*/
    @RequestMapping(value = "/auth/checklogin", method = RequestMethod.POST)
    public String checkLogin(ModelMap model,
                             @RequestParam("username") String username,
                             @RequestParam("password") String password) {

        //构造登陆令牌环
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try{
            //发出登陆请求
            SecurityUtils.getSubject().login(token);
            //登陆成功
            model.addAttribute("msg", "登录成功!");
            model.addAttribute("status", true);

        } catch (Exception e){
            model.addAttribute("msg", e.getMessage());
        }
        return "json";
    }

    @RequestMapping(value="/auth/logout")
    public String logout(){
        Subject currentUser = SecurityUtils.getSubject();
        if (SecurityUtils.getSubject().getSession() != null)
        {
            currentUser.logout();
        }
        return "redirect:/auth/login";
    }


}
