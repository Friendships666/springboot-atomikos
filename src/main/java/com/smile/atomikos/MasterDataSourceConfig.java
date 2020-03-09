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
@MapperScan(basePackages = "com.smile.mapper.master", sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {

    private static final String MAPPER_LOCATION = "classpath:mybatis/master/*.xml";


    @Bean(name = "masterDataSource")
    @Primary
    public DataSource masterDataSource(MasterDataSourceProperties property){
        MysqlXADataSource dataSource = new MysqlXADataSource();
        dataSource.setUrl(property.getJdbcUrl());
        dataSource.setUser(property.getUsername());
        dataSource.setPassword(property.getPassword());

        AtomikosDataSourceBean bean = new AtomikosDataSourceBean();
        bean.setXaDataSource(dataSource);
        bean.setUniqueResourceName("masterDataSource");
        return bean;
    }

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(masterDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return bean.getObject();
    }


    @Bean(name = "masterSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory masterSqlSessionFactory){
        return new SqlSessionTemplate(masterSqlSessionFactory);
    }


}
