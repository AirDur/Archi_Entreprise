package com.polytech.polyNet.infrastructure;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.polytech.polyNet.application.PublicationService;
import com.polytech.polyNet.application.PublicationServiceImpl;
import com.polytech.polyNet.data.JdbcStoryRepository;
import com.polytech.polyNet.data.StoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    StoryRepository storyRepository() {
        return new JdbcStoryRepository(datasource());
    }

    @Bean
    DataSource datasource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3333/PolyNet");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("root");
        mysqlDataSource.setDatabaseName("PolyNet");
        return mysqlDataSource;
    }

    @Bean
    PublicationService publicationService(){
        return new PublicationServiceImpl(storyRepository());
    }


}
