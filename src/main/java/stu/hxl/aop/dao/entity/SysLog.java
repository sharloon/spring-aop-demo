package stu.hxl.aop.dao.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 日志表
 * @author sharloon
 * @date 2019/8/13
 */
@Data
@TableName("sys_log")
public class SysLog {

    @TableId
    private Integer id;

    private String uri;

    private String title;

    private String className;

    private String methodName;

    private String requestParam;

    private String clientIp;

    private String clientUserAgent;

    private String userName;

    private Date time;

}
