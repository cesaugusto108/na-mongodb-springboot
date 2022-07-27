package cesaugusto108.mongodb_spring.services;

import cesaugusto108.mongodb_spring.domain.entities.Post;
import cesaugusto108.mongodb_spring.repositories.PostRepository;
import cesaugusto108.mongodb_spring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        return postRepository.titleSearch(text);
    }

    public List<Post> search(String text, Date startDate, Date endDate) {
        endDate = new Date(endDate.getTime() + 24 * 60 * 60 * 1000);

        return postRepository.search(text, startDate, endDate);
    }
}
