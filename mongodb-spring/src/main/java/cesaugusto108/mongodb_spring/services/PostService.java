package cesaugusto108.mongodb_spring.services;

import cesaugusto108.mongodb_spring.data_transfer_object.UserDataTransferObject;
import cesaugusto108.mongodb_spring.domain.entities.Post;
import cesaugusto108.mongodb_spring.domain.entities.User;
import cesaugusto108.mongodb_spring.repositories.PostRepository;
import cesaugusto108.mongodb_spring.repositories.UserRepository;
import cesaugusto108.mongodb_spring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);

        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}
