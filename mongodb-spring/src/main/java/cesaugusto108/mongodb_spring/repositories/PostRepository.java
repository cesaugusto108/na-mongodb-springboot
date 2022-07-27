package cesaugusto108.mongodb_spring.repositories;

import cesaugusto108.mongodb_spring.domain.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> titleSearch(String text);

    @Query(
            "{ $and: [ " +
                        "{ date: { $gte: ?1 } }," +
                        "{ date: { $lte: ?2 } } ," +
                        "{ $or: [ " +
                                    "{ 'title': { $regex: ?0, $options: 'i' } }," +
                                    "{ 'body': { $regex: ?0, $options: 'i' } }," +
                                    "{ 'commentDataTransferObjectList.text': { $regex: ?0, $options: 'i' } }" +
                                "] " +
                        "} " +
                    "] " +
            "}"
    )
    List<Post> search(String text, Date startDate, Date endDate);
}
