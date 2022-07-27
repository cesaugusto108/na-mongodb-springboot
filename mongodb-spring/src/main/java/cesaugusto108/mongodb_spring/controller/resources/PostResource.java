package cesaugusto108.mongodb_spring.controller.resources;

import cesaugusto108.mongodb_spring.controller.resources.util.URL;
import cesaugusto108.mongodb_spring.domain.entities.Post;
import cesaugusto108.mongodb_spring.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);

        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(
            @RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParameter(text);

        List<Post> postList = postService.findByTitle(text);

        return ResponseEntity.ok().body(postList);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> search(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "startDate", defaultValue = "") String startDate,
            @RequestParam(value = "endDate", defaultValue = "") String endDate
    ) {
        text = URL.decodeParameter(text);
        Date start = URL.convertDate(startDate, new Date(0L));
        Date end = URL.convertDate(endDate, new Date());

        List<Post> postList = postService.search(text, start, end);

        return ResponseEntity.ok().body(postList);
    }
}
