package com.kaisheng;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author liuyu
 * @date 2017/10/30
 */
//声明为Spring配置文件
@Configuration
//组件自动扫描
@ComponentScan
//基于注解的AOP(动态代理)
@EnableAspectJAutoProxy
//给予注释的事务管理
@EnableTransactionManagement
public class Application {

    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test");
        dataSource.setUsername("root");
        dataSource.setPassword("123321");
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){


        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
            DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
            dataSourceTransactionManager.setDataSource(dataSource());
            return dataSourceTransactionManager;
    }

}
