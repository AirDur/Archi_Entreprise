package com.polytech.polyNet.application;

import com.polytech.polyNet.object.Story;

import java.util.List;

public interface StoryDetailService {
    List getComment(Story s);

    Story getStory(Story id);
}
