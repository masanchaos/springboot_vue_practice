package com.msh.furn.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;


    @Slf4j
    @Configuration
    public class DruidDataSourceConfig {
        @ConfigurationProperties("spring.datasource")
        @Bean
        public DataSource dataSource() throws SQLException {
            DruidDataSource druidDataSource = new DruidDataSource();
            log.info("數據源={}",druidDataSource.getClass());
            return druidDataSource;
        }

}
