package cesaugusto108.mongodb_spring.config;

import cesaugusto108.mongodb_spring.domain.entities.Post;
import cesaugusto108.mongodb_spring.domain.entities.User;
import cesaugusto108.mongodb_spring.repositories.PostRepository;
import cesaugusto108.mongodb_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

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

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        Post post1 = new Post(
                userList.get(0),
                null,
                simpleDateFormat.parse("22/05/2022"),
                "Good morning",
                "Top of the day to y'all"
        );
        Post post2 = new Post(
                userList.get(0),
                null,
                simpleDateFormat.parse("22/05/2022"),
                "See ya",
                "Traveling abroad!"
        );

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
