package com.polytech.polyNet.repository;

import com.polytech.polyNet.object.Story;
import com.polytech.polyNet.object.Users;

import java.util.List;

public interface StoryRepository {

    void save(Story s);

    List findAll();

    List getComment(Story s);

    Story getStory(Story id);

    void register(Users u);
}
