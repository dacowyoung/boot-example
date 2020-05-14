package com.young.configure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis相关配置
 * 
 * @author young
 *
 */
@Configuration
@MapperScan({ "com.young.dao"})
public class MybatisConfiguration {
    
}
