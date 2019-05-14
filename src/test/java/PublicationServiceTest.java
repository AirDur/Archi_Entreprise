import com.polytech.polyNet.application.PublicationService;
import com.polytech.polyNet.application.PublicationServiceImpl;
import com.polytech.polyNet.application.Story;
import com.polytech.polyNet.data.MongoDBStoryRepository;
import com.polytech.polyNet.data.StoryRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class PublicationServiceTest {
    
    @Test
    public void should_save_story() {
        
        //GIVEN :
        StoryRepository storyRepository = new MongoDBStoryRepository();
        PublicationService ps = new PublicationServiceImpl(storyRepository);
        Story story1 = new Story("allez montpellier");
        Story story2 = new Story("allez marseille");

        //WHEN :
        
        ps.share(story1);
        ps.share(story2);

        //THEN :
        List stories = storyRepository.findAll();
        Assert.assertEquals(stories.size(), 2);
        Assert.assertEquals(asList(story1, story2), stories);
    }

    @Test
    public void change_story() {
        
    }
}