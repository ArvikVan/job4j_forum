package forum.service;

import forum.model.Post;
import forum.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

/**
 * @author ArvikV
 * @version 1.0
 * @since 10.02.2022
 * Сервисный слой
 * Все методы стандартные, проблема была с крудрепой и жпарепой, так и не
 * понял в чем разница, в обоих методы одинаковые
 */
@Service
@Transactional
public class PostService {
    private static final Logger LOG = LoggerFactory.getLogger(PostService.class);

    private final PostRepository posts;

    @Autowired
    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public Post savePost(Post post) {
        post.setCreated(Calendar.getInstance());
        return posts.save(post);
    }

    public void deleteById(Long id) {
           posts.deleteById(id);
    }

    public Optional<Post> findById(Long id) {
        return posts.findById(id);
    }
}
