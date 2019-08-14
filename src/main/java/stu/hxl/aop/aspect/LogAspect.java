package stu.hxl.aop.aspect;

import cn.hutool.extra.servlet.ServletUtil;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import stu.hxl.aop.annotation.BusinessLog;
import stu.hxl.aop.log.LogManager;
import stu.hxl.aop.log.LogTaskFactory;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private LogManager logManager;

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
    @Around("@annotation(businessLog)")
    public void around(ProceedingJoinPoint point, BusinessLog businessLog) {

        // 记录日志的逻辑不能影响正常的业务逻辑
        long startTime = System.currentTimeMillis();
        point.proceed();

        try {
            handle(point, businessLog, startTime);
        } catch (Exception e) {
            System.out.println("记录日志出现异常: " + e);
        }

    }

    private void handle(ProceedingJoinPoint point, BusinessLog businessLog, long startTime) {
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
        String title = businessLog.value();
        System.out.println("接口描述信息：" + title);

        //请求接口耗时
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("接口耗时：" + time);

        //用户
        String userName = getUserName(request);

        System.out.println("开始执行日志写入逻辑：");

        logManager.executeLog(LogTaskFactory.createBusinessLog(uri, title, className, methodName, requestParam, clientIP, UA, userName));
    }

    /**
     * 获取请求的用户
     * @param request
     * @return
     */
    private String getUserName(HttpServletRequest request) {

        String accessToken = request.getHeader("access_token");

        if(StringUtils.isEmpty(accessToken)) {
            accessToken = request.getParameter("access_token");
        }

        if(StringUtils.isEmpty(accessToken)) {
            return "";
        }

        //根据accessToken查询出对应的用户,这里具体业务具体实现

        return "sharloon";
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

        return StringUtils.isEmpty(sb.toString()) ? "" : sb.substring(0, sb.lastIndexOf("&"));
    }

}
