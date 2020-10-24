package com.example.board.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * DatabaseConfiguration
 */
@Configuration
@PropertySource("classpath:/application.properties")  //application.properties를 사용할수있게 해당 파일의 주소를 지정
public class DatabaseConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")  //위의 사용할 파일에서 설정한 데이터베이스 관련정보를 사용하도록 지정
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource() throws Exception {  //위에서 만들 설정파일을 테스트 하기위해 결과를 출력
        DataSource dataSource = new HikariDataSource(hikariConfig());
        System.out.println(dataSource.toString());
        return dataSource;
    }
}