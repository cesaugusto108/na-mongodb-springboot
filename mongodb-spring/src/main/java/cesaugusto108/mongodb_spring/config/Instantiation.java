package cesaugusto108.mongodb_spring.config;

import cesaugusto108.mongodb_spring.data_transfer_object.AuthorDataTransferObject;
import cesaugusto108.mongodb_spring.data_transfer_object.CommentDataTransferObject;
import cesaugusto108.mongodb_spring.domain.entities.Post;
import cesaugusto108.mongodb_spring.domain.entities.User;
import cesaugusto108.mongodb_spring.repositories.PostRepository;
import cesaugusto108.mongodb_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");

    @Override
    public void run(String... args) throws Exception {
        instantiateUsers();
        instantiatePosts(instantiateUsers());
    }

    private List<User> instantiateUsers() {
        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        List<User> userList = new ArrayList<>();
        userList.addAll(Arrays.asList(maria, alex, bob));

        userRepository.saveAll(userList);

        return userList;
    }

    private void instantiatePosts(List<User> userList) throws ParseException {
        postRepository.deleteAll();

        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        Post post1 = new Post(
                new AuthorDataTransferObject(userList.get(0)),
                null,
                simpleDateFormat.parse("22/05/2022"),
                "Good morning",
                "Top of the day to y'all"
        );
        Post post2 = new Post(
                new AuthorDataTransferObject(userList.get(0)),
                null,
                simpleDateFormat.parse("22/05/2022"),
                "See ya",
                "Traveling abroad!"
        );

        CommentDataTransferObject comment1 = new CommentDataTransferObject(
                "Enjoy!",
                simpleDateFormat.parse("22/05/2022"),
                new AuthorDataTransferObject(userList.get(1))
        );
        CommentDataTransferObject comment2 = new CommentDataTransferObject(
                "Have a nice trip!",
                simpleDateFormat.parse("22/05/2022"),
                new AuthorDataTransferObject(userList.get(2))
        );
        CommentDataTransferObject comment3 = new CommentDataTransferObject(
                "Have a nice day!",
                simpleDateFormat.parse("22/05/2022"),
                new AuthorDataTransferObject(userList.get(1))
        );

        post1.getCommentDataTransferObjectList()
                .addAll(Arrays.asList(comment3));
        post2.getCommentDataTransferObjectList()
                .addAll(Arrays.asList(comment1, comment2));

        postRepository.saveAll(Arrays.asList(post1, post2));

        userList.get(0).getPostList().addAll(Arrays.asList(post1, post2));
        userRepository.save(userList.get(0));
    }
}
