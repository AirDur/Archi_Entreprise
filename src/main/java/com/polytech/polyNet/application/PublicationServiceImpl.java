package com.polytech.polyNet.application;

import com.polytech.polyNet.object.Story;
import com.polytech.polyNet.repository.StoryRepository;

public class PublicationServiceImpl implements PublicationService {
    private StoryRepository storyRepository;

    public PublicationServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public void share(Story s) {
        storyRepository.save(s);
    }
}
