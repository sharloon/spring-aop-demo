package stu.hxl.aop.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * 日志切面, 记录每一个接口的请求参数和响应参数
 * @author sharloon
 * @date 2019/8/9
 */
@Aspect
@Configuration
public class LogAspect {

    /**
     * 定义切入点：拦截指定包下面的所有的controller
     */
    @Pointcut("execution(* stu.hxl.aop.controller.*.*(..))")
    public void executeService() {

    }

    @Before("executeService()")
    public void before() {

        System.out.println("进入controller之前，获取请求参数");

        ServletRequestAttributes sa = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = sa.getRequest();

        System.out.println("请求的uri= " + request.getRequestURI());

        System.out.println("请求类型method=" + request.getMethod());

        System.out.println("请求的本地ip=" + request.getLocalAddr());

        System.out.println("请求的远程ip=" + request.getRemoteAddr());

        System.out.println("请求参数:");
        Map<String, String[]> parameterMap = request.getParameterMap();

        for (String key : parameterMap.keySet()) {
            String[] value = parameterMap.get(key);

            System.out.println("key=" + key + ", value=" + Arrays.toString(value));
        }
    }

    @AfterReturning("executeService()")
    public void after() {

        // controller执行完毕之后调用
        System.out.println("after return");
    }
}
