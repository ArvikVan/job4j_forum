package forum.repository;

import forum.model.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ArvikV
 * @version 1.0
 * @since 10.02.2022
 */
public interface PostRepository extends CrudRepository<Post, Long> {
}
