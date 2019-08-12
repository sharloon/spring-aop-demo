package stu.hxl.aop.controller;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stu.hxl.aop.annotation.LoginCheck;
import stu.hxl.aop.annotation.SysLog;

/**
 * @author sharloon
 * @date 2019/8/10
 */
@LoginCheck
@RestController
@RequestMapping("/test")
public class TestController {

    @SneakyThrows
    @SysLog("say hello接口")
    @GetMapping("/hello")
    public String hello(String name) {
        Thread.sleep(1111);

        return "hello, " + name;
    }

}
