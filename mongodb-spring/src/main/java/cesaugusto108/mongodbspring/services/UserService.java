package cesaugusto108.mongodbspring.services;

import cesaugusto108.mongodbspring.domain.entities.User;
import cesaugusto108.mongodbspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
