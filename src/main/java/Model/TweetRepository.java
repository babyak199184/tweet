package Model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Audetore on 10.05.2017.
 */
@RepositoryRestResource(collectionResourceRel = "tweet", path = "tweet")
public interface TweetRepository extends MongoRepository<Tweet, String>{
    Tweet findByName(@Param("name")String name);
    Tweet findById(@Param("id") String id);
}
