package ru.isko.repositories.comments;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.isko.models.Comment;
import ru.isko.models.News;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByNews(News news);
}
