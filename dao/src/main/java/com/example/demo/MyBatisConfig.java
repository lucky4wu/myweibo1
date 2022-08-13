package com.example.demo;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.mybatis.spring.boot.autoconfigure.SqlSessionFactoryBeanCustomizer;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class MyBatisConfig {

    @Bean
    ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {

            }
        };
    }

    @Bean
    SqlSessionFactoryBeanCustomizer sqlSessionFactoryBeanCustomizer() {
        return new SqlSessionFactoryBeanCustomizer() {
            @Override
            public void customize(SqlSessionFactoryBean factoryBean) {
                factoryBean.setTypeAliasesPackage("com.example.demo.pojo");
            }
        };
    }

//    @Bean
//    public SqlSessionFactory masterSqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(masterDataSource());
//        factoryBean.setVfs(SpringBootVFS.class); // Sets the SpringBootVFS class into SqlSessionFactoryBean
//        // ...
//        return factoryBean.getObject();
//    }
//
//    private DataSource masterDataSource(){
//    }

//    @Bean
//    Interceptor myInterceptor() {
//        return null;
//    }
//    @Bean
//    TypeHandler myTypeHandler() {
//        return null;
//    }
//    @Bean
//    LanguageDriver myLanguageDriver() {
//        return null;
//    }

    @Bean
    VendorDatabaseIdProvider databaseIdProvider() {
        VendorDatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties properties = new Properties();
        properties.put("SQL Server", "sqlserver");
        properties.put("DB2", "db2");
        properties.put("H2", "h2");
        databaseIdProvider.setProperties(properties);
        return databaseIdProvider;
    }
}