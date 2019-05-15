package com.polytech.polyNet.application;

public class Comment {

    private Story story;
    private String content;
    public Comment(Story story, String content) {
        this.content  = content;
        this.story = story;
    }

    public String getContent() {
        return this.content;
    }
}
