package forum.control;

import forum.Main;
import forum.model.Post;
import forum.service.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author ArvikV
 * @version 1.0
 * @since 13.02.2022
 */
@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
@WebAppConfiguration
public class PostControlTest {
    private Post post;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
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
    public void givenIdTODeleteThenShouldDeleteThePost() {
        Post post = new Post(4L,  "postToDelete", "descOfPostToDelete");
        postService.savePost(post);
        postService.deleteById(post.getId());
        Optional<Post> optional = postService.findById(post.getId());
        Assertions.assertEquals(Optional.empty(), optional);
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(post("/post-create")
                        .param("name", "Пост"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(postService).savePost(argument.capture());
        assertThat(argument.getValue().getName(), is("Пост"));
    }

    @Test
    @WithMockUser
    public void saveAndUpdatePost() throws Exception {
        this.mockMvc.perform(post("/save")
                        .param("name", "ПровПост"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(postService).savePost(argument.capture());
        assertThat(argument.getValue().getName(), is("ПровПост"));
    }
}