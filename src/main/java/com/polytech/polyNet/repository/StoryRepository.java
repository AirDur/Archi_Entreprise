package com.polytech.polyNet.repository;

import com.polytech.polyNet.object.Story;

import java.util.List;

public interface StoryRepository {

    void save(Story s);

    List findAll();

    List getComment(Story s);

    Story getStory(Story id);
}
