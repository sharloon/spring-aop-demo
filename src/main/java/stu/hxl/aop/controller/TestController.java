package stu.hxl.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stu.hxl.aop.annotation.LoginCheck;

/**
 * @author sharloon
 * @date 2019/8/10
 */
@LoginCheck
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String hello(String name) {

        return "hello, " + name;
    }

}
