package forum.repository;

import forum.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ArvikV
 * @version 1.0
 * @since 10.02.2022
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
