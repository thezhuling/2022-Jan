package com.zhuling.repository.config;

import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Map;

/**
 * 功能描述:   数据源配置
 * 创建时间:    2021/05/19
 *
 * @author yuppie
 */
@Configuration
public class DataSourceConfig {

    @Resource
    private JpaProperties jpaProperties;
    @Resource
    private HibernateProperties hibernateProperties;

    @Bean(name = "primaryDataSource")
    @Primary
    @ConfigurationProperties("spring.datasource.primary")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "haiYinDataSource")
    @ConfigurationProperties("spring.datasource.haiyin")
    public DataSource haiYinDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "vendorProperties")
    public Map<String, Object> getVendorProperties() {
        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
    }

}
