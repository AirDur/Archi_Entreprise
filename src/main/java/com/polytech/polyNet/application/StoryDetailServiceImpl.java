package com.polytech.polyNet.application;

import com.polytech.polyNet.data.StoryRepository;

import java.util.List;

public class StoryDetailServiceImpl implements StoryDetailService {

    private final StoryRepository storyRepository;

    public StoryDetailServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override
    public List getComment(Story s) {
        return storyRepository.checkStory(s);
    }
}
