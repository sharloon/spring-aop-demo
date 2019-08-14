package stu.hxl.aop.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stu.hxl.aop.dao.entity.SysLog;
import stu.hxl.aop.service.SysLogService;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 日志管理器(单例模式)
 *
 * @author sharloon
 * @date 2019/8/14
 */
@Component
public class LogManager {

    @Autowired
    private SysLogService sysLogService;

    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

    //日志记录操作延时
    private final int OPERATE_DELAY_TIME = 10;

    public void executeLog(SysLog sysLog) {

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                sysLogService.save(sysLog);
            }
        };

        //延时10毫秒写入日志到数据库
        try {
            System.out.println("开始写入日志到数据库...");
            executorService.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS).get();
            System.out.println("写入日志到数据库完成...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
