package com.polytech.polyNet.object;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "story")
public class Story {

    public Story() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String content;

    @OneToMany()
    @JoinColumn(name = "story_id")
    private List<Comment> comments = new ArrayList<>();

    public Story(String content) {
        this.content  = content;
    }

    public Story(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Story(int id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public int getId() { return this.id; }
}
