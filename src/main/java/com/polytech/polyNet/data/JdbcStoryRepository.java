package com.polytech.polyNet.data;

import com.polytech.polyNet.application.Story;

import javax.sql.DataSource;
import java.util.List;

public class JdbcStoryRepository implements StoryRepository {

    DataSource dataSource;

    @Override
    public void save(Story s) {

    }

    @Override
    public List<Story> findAll() {
        return null;
    }
}
