import com.polytech.polyNet.application.FeedService;
import com.polytech.polyNet.application.FeedServiceImpl;
import com.polytech.polyNet.application.Story;
import com.polytech.polyNet.data.MongoDBStoryRepository;
import com.polytech.polyNet.data.StoryRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class FeedServiceTest {

    @Test
    public void should_fetch_user_feed() {
        //GIVEN :
        StoryRepository storyRepository = new MongoDBStoryRepository();
        FeedService feedService = new FeedServiceImpl(storyRepository);
        Story story1 = new Story("allez montpellier");
        Story story2 = new Story("allez marseille");

        //  WHEN :
        storyRepository.save(story1);
        storyRepository.save(story2);
        List stories = feedService.fetchAll();
        // THEN :
        Assert.assertEquals(stories.size(), 2);
        Assert.assertEquals(asList(story1, story2), stories);
    }
}