package cesaugusto108.mongodbspring.controller.resources;

import cesaugusto108.mongodbspring.domain.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Santos", "maria@email.com");
        User joao = new User("2", "João Santos", "joao@email.com");

        List<User> list = new ArrayList<>();
        list.add(maria);
        list.add(joao);

        return ResponseEntity.ok().body(list);
    }
}
