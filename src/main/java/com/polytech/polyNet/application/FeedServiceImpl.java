package com.polytech.polyNet.application;

import com.polytech.polyNet.application.FeedService;
import com.polytech.polyNet.application.Story;
import com.polytech.polyNet.data.StoryRepository;

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
