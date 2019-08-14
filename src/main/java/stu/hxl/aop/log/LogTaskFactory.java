package stu.hxl.aop.log;

import stu.hxl.aop.dao.entity.SysLog;

import java.util.TimerTask;

/**
 * @author sharloon
 * @date 2019/8/14
 */
public class LogTaskFactory {

    /**
     * 业务日志
     *
     * @param
     * @return
     */
    public static SysLog createBusinessLog(String uri, String title, String className, String methodName, String requestParam, String clientIP, String userAgent, String userName) {

        return new SysLog(uri, title, className, methodName, requestParam, clientIP, userAgent, userName);
    }

    /**
     * 异常日志
     *
     * @return
     */
    public static TimerTask createExceptionLog() {

        // TODO: 2019/8/14

        return new TimerTask() {
            @Override
            public void run() {

            }
        };

    }

}
