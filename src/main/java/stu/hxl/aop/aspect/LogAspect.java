package stu.hxl.aop.aspect;

import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HttpUtil;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import stu.hxl.aop.annotation.SysLog;
import sun.nio.cs.ext.GBK;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * 日志切面, 记录每一个接口的请求参数和响应参数
 *
 * @author sharloon
 * @date 2019/8/9
 */
@Aspect
@Configuration
public class LogAspect {

    /**
     * 方法一：通过定义切入点Pointcut
     * 定义切入点：拦截指定包下面的所有的controller
     */
//    @Pointcut("execution(* stu.hxl.aop.controller.*.*(..))")
//    public void executeService() {
//
//    }

    /**
     * 方法二： 通过自定义注解，结合@Around通知实现
     *
     * @param point
     */

    @SneakyThrows
    @Around("@annotation(sysLog)")
    public void around(ProceedingJoinPoint point, SysLog sysLog) {

//        log.info("===================================================================================================");

        // 记录日志的逻辑不能影响正常的业务逻辑
        long startTime = System.currentTimeMillis();
        point.proceed();

        try {
            handle(point, sysLog, startTime);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void handle(ProceedingJoinPoint point, SysLog sysLog, long startTime) {
        //获取请求的类
        String className = point.getTarget().getClass().getName();
        System.out.println("类名： " + className);

        //获取请求的方法
        String methodName = point.getSignature().getName();
        System.out.println("方法名： " + methodName);

        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();

        //获取请求的uri
        String uri = request.getRequestURI();
        System.out.println("请求的接口地址：" + uri);

        //获取请求参数
        String requestParam = getRequestParams(request);
        System.out.println("请求参数：" + requestParam);

        //获取客户端ip(使用hutool)
        String clientIP = ServletUtil.getClientIP(request);
        System.out.println("客户端ip: " + clientIP);

        //获取用户客户端信息user-agent
        String UA = request.getHeader("user-agent");
        System.out.println("客户端信息：" + UA);

        //请求接口的用户(不同系统方式不一样,此处以通过header保存token的形式来传递用户信息)
        String accessToken = request.getHeader("access-token");
        System.out.println("请求的用户名：" + accessToken);

        // 接口描述信息
        String desc = sysLog.value();
        System.out.println("接口描述信息：" + desc);

        //请求接口耗时
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("接口耗时：" + time);
    }

    private String getRequestParams(HttpServletRequest request) {

        //直接使用hutool的HttpUtil,但是有编码问题，暂不使用
//        return HttpUtil.toParams(request.getParameterMap());

        Map<String, String[]> parameterMap = request.getParameterMap();

        StringBuilder sb = new StringBuilder();

        for (String key : parameterMap.keySet()) {

            String value = request.getParameter(key);

            sb.append(key + "=" + value);

            sb.append(" & ");
        }

        return sb.substring(0, sb.lastIndexOf("&") - 1);
    }

}
