package com.polytech.polyNet;

import com.polytech.polyNet.application.Story;
import com.polytech.polyNet.data.StoryRepository;
import com.polytech.polyNet.infrastructure.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AppConfig.class);
        StoryRepository storyRepository = context.getBean(StoryRepository.class);
        storyRepository.save(new Story("MARSEILLE"));
        storyRepository.save(new Story("TOULOUSE"));
        storyRepository.save(new Story("MONTPELLIER"));

        List<Story> list = storyRepository.findAll();
        for(Story story : list) {
            System.out.println(story.getContent());
        }
    }
}
