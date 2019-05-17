package com.polytech.polyNet.api;

import com.polytech.polyNet.application.*;
import com.polytech.polyNet.object.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @PostMapping("/share")
    public void share(@RequestBody Story content) {
        publicationService.share(content);
    }

    @GetMapping("/feed")
    public List feed(Principal principal) {
        String username = principal.getName();

        return feedService.fetchAll();
    }

    @GetMapping("/toto")
    public void toto(@RequestParam("id") Long id, @RequestParam("content") String content) {
        System.out.println(id + " : " + content);
    }

    @PostMapping("/commentStory")
    public List commentStory(@RequestBody Story id) {
        return storyDetailService.getComment(id);
    }

    @PostMapping("/story")
    public Story story(@RequestBody Story id) {
        return storyDetailService.getStory(id);
    }

}
