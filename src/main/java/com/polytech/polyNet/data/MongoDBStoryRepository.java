package com.polytech.polyNet.data;

import com.polytech.polyNet.application.Story;

import java.util.ArrayList;
import java.util.List;

public class MongoDBStoryRepository implements StoryRepository {

    List<Story> database = new ArrayList<Story>();

    public void save(Story s) {
        database.add(s);
    }

    public List<Story> findAll() {
        return database;
    }
}
