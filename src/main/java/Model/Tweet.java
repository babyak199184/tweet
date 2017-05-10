package Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Audetore on 10.05.2017.
 */
@Data
@SuppressWarnings("serial")
@Document(collection = "tweets")
public class Tweet {

    @Id
    @Indexed(unique = true)
    private String id;
    private String name;
    private String content;

    public Tweet() {
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Tweet(String id, String content) {
        this.content = content;
        this.id = id;

    }

}
