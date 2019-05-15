package com.polytech.polyNet.view;

import com.polytech.polyNet.application.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoryController {

    private FeedService feedService;
    private PublicationService publicationService;
    private StoryDetailService storyDetailService;

    @Autowired
    public StoryController(PublicationService publicationService, FeedService feedService,
                           StoryDetailService storyDetailService) {
        this.publicationService = publicationService;
        this.feedService = feedService;
        this.storyDetailService = storyDetailService;
    }

    @PostMapping("/more")
    public void share(String content) {
        publicationService.share(new Story(content));
    }

    @GetMapping("/feed")
    public List<Story> feed() {
        return feedService.fetchAll();
    }

    @GetMapping("/toto")
    public void toto(@RequestParam("id") Long id, @RequestParam("content") String content) {
        System.out.println(id + " : " + content);
    }

    @PostMapping("/story")
    public List<Comment> story(Story story) {
        return storyDetailService.getComment(story);
    }
}
