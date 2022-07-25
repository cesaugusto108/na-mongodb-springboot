package cesaugusto108.mongodbspring.repositories;

import cesaugusto108.mongodbspring.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
