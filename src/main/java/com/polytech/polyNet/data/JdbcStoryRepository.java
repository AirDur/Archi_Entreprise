package com.polytech.polyNet.data;

import com.polytech.polyNet.application.Comment;
import com.polytech.polyNet.application.Story;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcStoryRepository implements StoryRepository {

    private DataSource dataSource;

    public JdbcStoryRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public void save(Story s) {
        try {
            Connection connection = dataSource.getConnection();
            String sql = "INSERT INTO Story(CONTENT) VALUES('" + s.getContent() + "')";
            connection.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Story> findAll() {
        List<Story> result = new ArrayList<>();
        try {
            // GET CONNEXION :
            Connection connection = dataSource.getConnection();
            String sql = "SELECT * FROM Story";
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while(resultSet.next()) {
                String content = resultSet.getString("CONTENT");
                int id = resultSet.getInt("ID");
                result.add(new Story(id, content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Comment> checkStory(Story s) {
        List<Comment> result = new ArrayList<>();
        try {
            //GET CONNEXION :
            Connection connection = dataSource.getConnection();
            String sql = "SELECT * FROM Comment WHERE STORY_ID=" + s.getId();
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while(resultSet.next()) {
                String content = resultSet.getString("CONTENT");
                result.add(new Comment(s, content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
