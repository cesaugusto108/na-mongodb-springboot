package cesaugusto108.mongodb_spring.services;

import cesaugusto108.mongodb_spring.domain.entities.User;
import cesaugusto108.mongodb_spring.repositories.UserRepository;
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
