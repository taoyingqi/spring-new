package com.qed.controller;

import com.qed.entity.User;
import com.qed.repository.UserReps;
import com.qed.service.UserServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2015/10/13.
 */
@Controller
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private UserReps userReps;
    @Autowired
    private UserServiceI userService;

    @RequestMapping(value = "/hello.do", method = RequestMethod.GET)
    public String hello(User user) {
        logger.debug("user: " + userReps.findAll());
        return "hello";
    }

    @RequestMapping(value = "/hello.do", method = RequestMethod.POST)
    public String doHello(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "hello";
        }
        //userReps.save(user);
        userService.save(user);
        logger.debug(user.getName());
        return "redirect:/hello.do";
    }

    @RequestMapping(value = "/users.do")
    @ResponseBody
    public List<User> json() {
        return userReps.findAll();
    }
}
