package Controllers;

import Model.Tweet;
import Model.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Audetore on 10.05.2017.
 */
@RestController
public class EndpointController {

    @Autowired
    public EndpointController(TweetRepository repository) {
        this.repository = repository;
    }

    private final TweetRepository repository;


    @PostConstruct
    public void initData() {
        repository.deleteAll();
        repository.save(new Tweet("tweet_1", "Peirwszy"));
        repository.save(new Tweet("tweet_2", "Drugi"));
        repository.save(new Tweet("tweet_3", "Trzeci"));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Object createTweet(Tweet tweet) {
        return repository.save(tweet);
    }

    @RequestMapping("/tweets")
    public List<Tweet> getAllTweets() {
        return repository.findAll();
    }

    @RequestMapping(value = "/tweets/{tweetId}")
    public Tweet getTweet(@PathVariable("tweetId") String tweetId) {
        return repository.findById(tweetId);
    }

}
