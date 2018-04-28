package ru.isko.services;

import org.springframework.security.core.Authentication;
import ru.isko.forms.CommentsForm;
import ru.isko.models.Comment;

import java.util.List;

public interface CommentService {

    Comment addComment(CommentsForm commentsForm, Authentication authentication);
    List<Comment> getAll();
    void deleteComment(Long id);
    List<Comment> sortComment(List<Comment> comments);
}
