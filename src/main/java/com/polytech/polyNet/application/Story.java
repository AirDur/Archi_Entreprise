package com.polytech.polyNet.application;

public class Story {

    private String content;
    private int id;

    public Story(String content) {
        this.content  = content;
    }

    public Story(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public int getId() { return this.id; }
}
