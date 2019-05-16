package com.polytech.polyNet.object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

    public Comment() {}

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "content")
    private String content;

    public Comment(Story story, String content) {
        this.content  = content;
    }

    public String getContent() {
        return this.content;
    }
}
