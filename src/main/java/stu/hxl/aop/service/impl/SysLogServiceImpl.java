package stu.hxl.aop.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import stu.hxl.aop.dao.entity.SysLog;
import stu.hxl.aop.dao.mapper.SysLogMapper;
import stu.hxl.aop.service.SysLogService;

/**
 * @author sharloon
 * @date 2019/8/13
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

}
