package stu.hxl.aop.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stu.hxl.aop.annotation.LoginCheck;
import stu.hxl.aop.annotation.SysLog;
import stu.hxl.aop.service.SysLogService;

/**
 * @author sharloon
 * @date 2019/8/10
 */
@LoginCheck
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private SysLogService sysLogService;

    @SneakyThrows
    @SysLog("say hello接口")
    @GetMapping("/hello")
    public String hello(String name) {

        stu.hxl.aop.dao.entity.SysLog sysLog = sysLogService.selectById(1);

        System.out.println("log: " + sysLog.toString());

        return "hello, " + name;
    }

}
