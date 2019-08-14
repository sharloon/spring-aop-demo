package stu.hxl.aop.dao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 日志表
 *
 * @author sharloon
 * @date 2019/8/13
 */
@Data
@NoArgsConstructor
@TableName("sys_log")
public class SysLog extends Model<SysLog> {

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

    public SysLog(String uri, String title, String className, String methodName, String requestParam, String clientIp, String clientUserAgent, String userName) {
        this.uri = uri;
        this.title = title;
        this.className = className;
        this.methodName = methodName;
        this.requestParam = requestParam;
        this.clientIp = clientIp;
        this.clientUserAgent = clientUserAgent;
        this.userName = userName;
        this.time = new Date();
    }
}
