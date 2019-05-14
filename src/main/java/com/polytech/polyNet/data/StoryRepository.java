package com.polytech.polyNet.data;

import com.polytech.polyNet.application.Story;

import java.util.List;

public interface StoryRepository {

    public void save(Story s);

    public List<Story> findAll();
}
