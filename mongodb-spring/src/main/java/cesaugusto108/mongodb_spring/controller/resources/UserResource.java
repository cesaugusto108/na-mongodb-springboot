package cesaugusto108.mongodb_spring.controller.resources;

import cesaugusto108.mongodb_spring.data_transfer_object.UserDataTransferObject;
import cesaugusto108.mongodb_spring.domain.entities.Post;
import cesaugusto108.mongodb_spring.domain.entities.User;
import cesaugusto108.mongodb_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDataTransferObject>> findAll() {
        List<User> userList = userService.findAll();
        List<UserDataTransferObject> userDataTransferObjectList =
                userList.stream().map(user -> new UserDataTransferObject(user)).collect(Collectors.toList());

        return ResponseEntity.ok().body(userDataTransferObjectList);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDataTransferObject> findById(@PathVariable String id) {
        User user = userService.findById(id);

        return ResponseEntity.ok().body(new UserDataTransferObject(user));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(
            @PathVariable String id,
            @RequestBody UserDataTransferObject userDataTransferObject
    ) {
        User user = userService.userFromDataTransferObject(userDataTransferObject);
        user.setId(id);
        user = userService.update(user);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDataTransferObject userDataTransferObject) {
        User user = userService.userFromDataTransferObject(userDataTransferObject);
        user = userService.insert(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findPostsByUserId(@PathVariable String id) {
        User user = userService.findById(id);

        return ResponseEntity.ok().body(user.getPostList());
    }
}
