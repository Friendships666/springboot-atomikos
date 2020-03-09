package com.smile.atomikos;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @时间 2020/3/9 13:54
 * @作者 liutao
 * @描述
 */
@Configuration
@MapperScan(basePackages = "com.smile.mapper.slaver", sqlSessionFactoryRef = "slaverSqlSessionFactory")
public class SlaverDataSourceConfig {

    private static final String MAPPER_LOCATION = "classpath:mybatis/slaver/*.xml";

    @Bean(name = "slaverDataSource")
    public DataSource slaverDataSource(SlaverDataSourceProperties property){
        MysqlXADataSource dataSource = new MysqlXADataSource();
        dataSource.setUrl(property.getJdbcUrl());
        dataSource.setUser(property.getUsername());
        dataSource.setPassword(property.getPassword());

        AtomikosDataSourceBean bean = new AtomikosDataSourceBean();
        bean.setXaDataSource(dataSource);
        bean.setUniqueResourceName("slaverDataSource");
        return bean;
    }

    @Bean(name = "slaverSqlSessionFactory")
    public SqlSessionFactory slaverSqlSessionFactory(@Qualifier("slaverDataSource") DataSource slaverDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(slaverDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return bean.getObject();
    }


    @Bean(name = "slaverSqlSessionTemplate")
    public SqlSessionTemplate slaverSqlSessionTemplate(@Qualifier("slaverSqlSessionFactory") SqlSessionFactory slaverSqlSessionFactory){
        return new SqlSessionTemplate(slaverSqlSessionFactory);
    }


}
