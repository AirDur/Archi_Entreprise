package com.polytech.polyNet.object;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Story")
public class Story {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CONTENT")
    private String content;

    @OneToMany()
    @JoinColumn(name = "STORY_ID")
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
