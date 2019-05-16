package com.polytech.polyNet.application;

import com.polytech.polyNet.object.Story;
import com.polytech.polyNet.repository.StoryRepository;

import java.util.List;

public class FeedServiceImpl implements FeedService {
    private StoryRepository storyRepository;

    public FeedServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public List<Story> fetchAll() {
        return this.storyRepository.findAll();
    }
}
