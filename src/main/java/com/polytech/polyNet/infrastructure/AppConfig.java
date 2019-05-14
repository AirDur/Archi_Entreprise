package com.polytech.polyNet.infrastructure;

import com.polytech.polyNet.application.PublicationService;
import com.polytech.polyNet.application.PublicationServiceImpl;
import com.polytech.polyNet.data.MongoDBStoryRepository;
import com.polytech.polyNet.data.StoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    StoryRepository storyRepository() {
        return new MongoDBStoryRepository();
    }
    @Bean
    PublicationService publicationService(){
        return new PublicationServiceImpl(storyRepository());
    }
}
