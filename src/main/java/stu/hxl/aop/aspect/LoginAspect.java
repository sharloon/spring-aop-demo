package stu.hxl.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录切面
 * @author sharloon
 * @date 2019/8/9
 */
@Aspect
@Configuration
public class LoginAspect {

    @Around("@annotation(stu.hxl.aop.annotation.LoginCheck)")
    public Object checkLogin(ProceedingJoinPoint point) throws Throwable {

        // 使用 RequestContextHolder 工具获取Http的相关信息
        ServletRequestAttributes sa = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = sa.getRequest();

        String name = request.getParameter("name");

        System.out.println(name);

        return point.proceed();
    }

}
