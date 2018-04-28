package ru.isko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.isko.forms.CommentsForm;
import ru.isko.services.CommentService;

/**
 * created by Iskander Valiev
 * on 11/25/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Controller
public class CommentsController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/postcomment")
    public String postComment(@ModelAttribute("model")ModelMap model, Authentication authentication, CommentsForm commentsForm) {
        commentService.addComment(commentsForm, authentication);
        return "redirect:/user/news/"+commentsForm.getNewsId();
    }
}
