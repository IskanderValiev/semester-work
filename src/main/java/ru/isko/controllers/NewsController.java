package ru.isko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.isko.forms.NewsForm;
import ru.isko.models.News;
import ru.isko.repositories.comments.CommentsRepository;
import ru.isko.repositories.news.NewsRepository;
import ru.isko.services.AuthenticationService;
import ru.isko.services.CommentService;
import ru.isko.services.NewsService;

/**
 * created by Iskander Valiev
 * on 11/23/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Controller
public class NewsController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsService newsService;

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private CommentService commentService;

    @GetMapping("/user/news")
    public String news(@ModelAttribute("model")ModelMap model, Authentication authentication) {
        model.addAttribute("user",authenticationService.getUser(authentication));
        model.addAttribute("news", newsService.sortNews(newsRepository.findByType("News")));
        model.addAttribute("articles", newsService.sortNews(newsRepository.findByType("Article")));
        model.addAttribute("blogs", newsService.sortNews(newsRepository.findByType("Blog")));
        return "news";
    }

    @GetMapping("/admin/add/news")
    public String addnews() {
        return "admin/addnews";
    }

    @PostMapping("/admin/postnews")
    public String postNews(@RequestParam("file")MultipartFile file, @ModelAttribute("newsForm") NewsForm newsForm) {
        newsService.addNews(file, newsForm);
        return "redirect:/admin/news";
    }

    @GetMapping("/user/news/{news-id}")
    public String openNewsPage(@ModelAttribute("model") ModelMap model, @PathVariable("news-id") Long newsId, Authentication authentication) {
        News news = newsRepository.findOne(newsId);
        model.addAttribute("news", newsRepository.findOne(newsId));
        model.addAttribute("comments", commentService.sortComment(commentsRepository.findAllByNews(news)));
        model.addAttribute("user", authenticationService.getUser(authentication));
        return "selected_news";
    }

    @GetMapping("/admin/delete/{comment-id}")
    public String deleteComment(@PathVariable("comment-id")Long id) {
        Long newsID = commentsRepository.findOne(id).getNews().getId();
        commentsRepository.delete(id);
        return "redirect:/user/news/"+newsID;
    }

}
