package forum.control;

import forum.Main;
import forum.model.Post;
import forum.service.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Calendar;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author ArvikV
 * @version 1.0
 * @since 13.02.2022
 */
@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class PostControlTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private PostService postService;

    @Test
    @WithMockUser
    public void createPostForm() throws Exception {
        this.mockMvc.perform(get("/post-create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("forum/createPost"));
    }

    @Test
    @Rollback(value = false)
    public void deletePost() throws Exception {
        Post post = Post.of("name");
        postService.deleteById(post.getId());
        Optional<Post> deletePost = postService.findById(1L);
        assertThat(deletePost).isEmpty();
    }
    /*
    @Test
    @WithMockUser
    public void updatePost() throws Exception {
        this.mockMvc.perform(get("/post-update"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("forum/updatePost"));
    }
    */

    @Test
    public void updatePost() {
        Post post = Post.of("name");
        post.setName("Nombre");
        postService.savePost(post);
        assertThat(post.getName()).isEqualTo("Nombre");
    }
}