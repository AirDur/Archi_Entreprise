package com.polytech.polyNet;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.polytech.polyNet.application.*;
import com.polytech.polyNet.repository.JpaStoryRepository;
import com.polytech.polyNet.repository.StoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    StoryRepository storyRepository() {
        return new JpaStoryRepository();
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
    PublicationService publicationService() {
        return new PublicationServiceImpl(storyRepository());
    }

    @Bean
    FeedService feedService() {
        return new FeedServiceImpl(storyRepository());
    }

    @Bean
    StoryDetailService storyDetailService() { return new StoryDetailServiceImpl(storyRepository());}

}
