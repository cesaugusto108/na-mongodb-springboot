package cesaugusto108.mongodb_spring.controller.resources;

import cesaugusto108.mongodb_spring.data_transfer_object.UserDataTransferObject;
import cesaugusto108.mongodb_spring.domain.entities.User;
import cesaugusto108.mongodb_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
