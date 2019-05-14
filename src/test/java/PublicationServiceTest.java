import com.polytech.polyNet.infrastructure.AppConfig;
import com.polytech.polyNet.application.PublicationService;
import com.polytech.polyNet.application.Story;
import com.polytech.polyNet.data.StoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static java.util.Arrays.asList;

public class PublicationServiceTest {

    @Test
    public void should_save_story() {

        ApplicationContext context = SpringApplication.run(AppConfig.class);

        //GIVEN :
        StoryRepository storyRepository = context.getBean(StoryRepository.class);
        PublicationService ps = context.getBean(PublicationService.class);
        Story story1 = new Story("allez montpellier");
        Story story2 = new Story("allez marseille");

        //WHEN :
        
        ps.share(story1);
        ps.share(story2);

        //THEN :
        List stories = storyRepository.findAll();
        //Assert.assertEquals(stories.size(), 2);
        //Assert.assertEquals(asList(story1, story2), stories);
    }

    @Test
    public void change_story() {

    }
}