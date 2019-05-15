package com.polytech.polyNet.data;

import com.polytech.polyNet.application.Story;

import java.util.List;

public interface StoryRepository {

    void save(Story s);

    List<Story> findAll();
}
