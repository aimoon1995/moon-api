package com.moon.moon_datasource.config.dataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @ClassName DataSourceGdDataConfig
 * @Description: TODO
 * @Author zyl
 * @Date 2020/11/18
 * @Version V1.0
 **/
@Configuration
@MapperScan(basePackages = "com.hexing.d2d.mapper" , sqlSessionFactoryRef = "updSqlSessionFactory")
public class DataSourceGdDataConfig {


    @Bean(name = "updSqlSessionFactory")
    public SqlSessionFactory serverSqlSessionFactory(@Qualifier("secondaryDataSource") DataSource dataSource)
            throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "updTransactionManager")
    public DataSourceTransactionManager serverTransactionManager(@Qualifier("secondaryDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "updSqlSessionTemplate")
    public SqlSessionTemplate serverSqlSessionTemplate(@Qualifier("updSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
