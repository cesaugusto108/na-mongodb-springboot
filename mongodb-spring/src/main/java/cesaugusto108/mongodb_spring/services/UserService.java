package cesaugusto108.mongodb_spring.services;

import cesaugusto108.mongodb_spring.data_transfer_object.UserDataTransferObject;
import cesaugusto108.mongodb_spring.domain.entities.User;
import cesaugusto108.mongodb_spring.repositories.UserRepository;
import cesaugusto108.mongodb_spring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User updatedAttributesUser) {
        User existingAttributesUser = findById(updatedAttributesUser.getId());
        updateData(existingAttributesUser, updatedAttributesUser);

        return userRepository.save(existingAttributesUser);
    }

    private void updateData(User existingAttributesUser, User updatedAttributesUser) {
        existingAttributesUser.setName(updatedAttributesUser.getName());
        existingAttributesUser.setEmail(updatedAttributesUser.getEmail());
    }

    public User userFromDataTransferObject(UserDataTransferObject userDataTransferObject) {
        return new User(
                userDataTransferObject.getId(),
                userDataTransferObject.getName(),
                userDataTransferObject.getEmail()
        );
    }
}
