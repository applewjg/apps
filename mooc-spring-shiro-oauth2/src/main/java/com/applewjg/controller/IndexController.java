package com.applewjg.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
        Subject currentUser = SecurityUtils.getSubject();

        String username = "";
        String password = "";
        if (currentUser != null) {
            try {
                username = currentUser.getPrincipal().toString();
            } catch (Exception e) {
                username = currentUser.toString();
            }
        }

        logger.info("登录用户: " + username);

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
