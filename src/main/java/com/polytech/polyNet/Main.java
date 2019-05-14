package com.polytech.polyNet;

import com.polytech.polyNet.application.PublicationService;
import com.polytech.polyNet.application.PublicationServiceImpl;
import com.polytech.polyNet.application.Story;
import com.polytech.polyNet.data.Neo4JStoryRepository;
import com.polytech.polyNet.data.StoryRepository;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //DATA :
        StoryRepository storyRepository = new Neo4JStoryRepository();

        //APPLICATION :
        PublicationService publicationService = new PublicationServiceImpl(storyRepository);
        publicationService.share(new Story("Hello Polytech"));

        List<Story> stories = storyRepository.findAll();
        for (Story s : stories) {
            System.out.println(s.toString());
        }
    }
}
