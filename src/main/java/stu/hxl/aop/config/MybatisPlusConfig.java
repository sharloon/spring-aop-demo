package stu.hxl.aop.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis-plus配置类
 * @author sharloon
 * @date 2019/8/13
 */
@Configuration
@MapperScan("stu.hxl.aop.dao.mapper*")
public class MybatisPlusConfig {

    /**
     * 分页插件，自动识别数据库类型
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
