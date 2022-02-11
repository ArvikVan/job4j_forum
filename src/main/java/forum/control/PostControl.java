package forum.control;

import forum.model.Post;
import forum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author ArvikV
 * @version 1.0
 * @since 11.02.2022
 * работаем через сервисный слой
 */
@Controller
public class PostControl {
    private final PostService posts;

    @Autowired
    public PostControl(PostService posts) {
        this.posts = posts;
    }

    /**
     * отсылка на страницу с формой создания поста в маппинге указатель на  value='/post-create жсп страницы
     * @param post пост
     * @return идем на страниу креатепост
     */
    @GetMapping("/post-create")
    public String createPostForm(Post post) {
        return "forum/createPost";
    }

    /**
     * создаем пост
     * @param post пост
     * @return на выходе созданный пост
     */
    @PostMapping("/post-create")
    public String createPost(Post post) {
        posts.savePost(post);
        return "redirect:/";
    }

    /**
     * Deleting
     * @param id byId
     * @return return to main page
     */
    @GetMapping("/post-delete")
    public String deletePost(@RequestParam("id") Long id) {
        posts.deleteById(id);
        return "redirect:/";
    }

    /**
     * получаем страницу для обнов
     * @param id ид
     * @param model модел
     * @return на выходе страница с введнными полями для обновы
     */
    @GetMapping("/post-update")
    public String updatePost(@RequestParam("id") Long id, Model model) {
        model.addAttribute("post", posts.findById(id).get());
        return "forum/updatePost";
    }

    /**
     * Обновляем
     * @param post пост для обновы
     * @return на выходе обнова
     */
    @PostMapping("/save")
    public String savePost(@ModelAttribute Post post) {
        posts.savePost(post);
        return "redirect:/";
    }
}