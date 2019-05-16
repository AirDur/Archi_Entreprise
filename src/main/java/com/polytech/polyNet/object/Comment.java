package com.polytech.polyNet.object;

import com.polytech.polyNet.object.Story;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Comment")
public class Comment {

    @Id
    @Column(name = "ID")
    private Integer id;

    private Story story;

    @Column(name = "CONTENT")
    private String content;

    public Comment(Story story, String content) {
        this.content  = content;
        this.story = story;
    }

    public String getContent() {
        return this.content;
    }
}
