package com.polytech.polyNet.repository;

import com.polytech.polyNet.object.Comment;
import com.polytech.polyNet.object.Story;

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
            String sql = "INSERT INTO story(content) VALUES('" + s.getContent() + "')";
            connection.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List findAll() {
        List<Story> result = new ArrayList<>();
        try {
            // GET CONNEXION :
            Connection connection = dataSource.getConnection();
            String sql = "SELECT * FROM story";
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
    public Story getStory(Story id) {

        List<Story> result = new ArrayList<>();
        try {
            //GET CONNEXION :
            Connection connection = dataSource.getConnection();
            String sql = "SELECT * FROM story WHERE id=" + id.getId();
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while(resultSet.next()) {
                String content = resultSet.getString("CONTENT");
                int tempon_id = resultSet.getInt("ID");
                result.add(new Story(tempon_id, content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.get(0);
    }

    @Override
    public List getComment(Story s) {
        List<Comment> result = new ArrayList<>();
        try {
            //GET CONNEXION :
            Connection connection = dataSource.getConnection();
            String sql = "SELECT * FROM comment WHERE story_id=" + s.getId();
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
