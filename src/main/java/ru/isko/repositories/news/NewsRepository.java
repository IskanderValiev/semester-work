package ru.isko.repositories.news;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.isko.models.News;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> /*CustomNewsRepository*/ {
    List<News> findByType(String type);
}
