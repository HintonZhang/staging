package com.hinton.staging.test.config;

/**
 * Created by duanwenhui on 2017/7/1.
 */


import com.hinton.mysql.BaseDatasourceConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 *
 * @author duanwenhui
 * @date 2017/06/23
 */
@Configuration
@MapperScan(
        basePackages = {
                "com.hinton.staging.test.mapper"},
        sqlSessionFactoryRef = com.hinton.staging.test.config.PrimaryDatasourceConfig.PRIMARY_SQL_SESSION_FACTORY)
public class PrimaryDatasourceConfig extends BaseDatasourceConfig {
    public static final String PRIMARY_SQL_SESSION_FACTORY = "primarySessionFactory";
    public static final String PRIMARY_TX_MANAGER = "primaryTxManager";
    public static final String PRIMARY_DATA_SOURCE = "primaryDataSource";


    @Bean(name = PRIMARY_DATA_SOURCE)
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource dataSourcePrimary() {
        return DataSourceBuilder.create().type(org.apache.commons.dbcp2.BasicDataSource.class).build();
    }


    @Bean(name = PRIMARY_TX_MANAGER)
    public PlatformTransactionManager txManagerPrimary(@Qualifier(PRIMARY_DATA_SOURCE) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = com.hinton.staging.test.config.PrimaryDatasourceConfig.PRIMARY_SQL_SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier(PRIMARY_DATA_SOURCE) DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return addPageInterceptor(sqlSessionFactoryBean.getObject());
    }
}
