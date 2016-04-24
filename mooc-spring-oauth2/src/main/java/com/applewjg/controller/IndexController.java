package com.applewjg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by baidu on 16/4/22.
 */
@Controller
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        logger.info("root");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //UserDetails account = (auth != null) ? (UserDetails)auth.getPrincipal() :  null;
        //UserDetails userDetails = (auth != null) ? (UserDetails)auth.getDetails() : null;
        SecurityContext securityContext = SecurityContextHolder.getContext();
        //获取认证对象
        Authentication authentication = securityContext.getAuthentication();
        //在认证对象中获取主体对象
        Object principal = authentication.getPrincipal();

        String username = "";
        String password = "";
        if(principal instanceof UserDetails){
            username = ((UserDetails) principal).getUsername();
        }else {
            username = principal.toString();
        }

        logger.info("登录用户: " + auth.getName());

        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap modelMap, HttpServletRequest httpServletRequest,
                        HttpServletResponse httpServletResponse) {
        logger.info("root index");
        return "index";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        logger.info("root login");
        return "login";
    }
}
