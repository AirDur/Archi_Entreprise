package com.polytech.polyNet.application;

import com.polytech.polyNet.object.Story;
import com.polytech.polyNet.repository.StoryRepository;

import java.util.List;

public class StoryDetailServiceImpl implements StoryDetailService {

    private final StoryRepository storyRepository;

    public StoryDetailServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override
    public List getComment(Story s) {
        return storyRepository.getComment(s);
    }

    @Override
    public Story getStory(Story id) {
        return storyRepository.getStory(id);
    }
}
