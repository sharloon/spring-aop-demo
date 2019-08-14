package stu.hxl.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志注解，作用于方法上，通过LogAspect记录方法的执行日志
 *
 * @author sharloon
 * @date 2019/8/12
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BusinessLog {

    /**
     * 描述
     *
     * @return
     */
    String value() default "";
}
