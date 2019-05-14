package com.polytech.polyNet.controller;

import com.polytech.polyNet.application.Story;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class StoryController {

    @PostMapping
    public void share(String content) {
        Story story = new Story(content);

    }

    @GetMapping("/feed")
    public List<Story> feed() {
        return Collections.singletonList(new Story("Allez Marseille"));
    }

    @GetMapping("/toto")
    public void toto(@RequestParam("id") Long id, @RequestParam("content") String content) {
        System.out.println(id + " : " + content);
    }
}
