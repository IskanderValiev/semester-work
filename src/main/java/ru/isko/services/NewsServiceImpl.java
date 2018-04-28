package ru.isko.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.isko.comparators.NewsDateComparator;
import ru.isko.forms.NewsForm;
import ru.isko.models.FileInfo;
import ru.isko.models.News;
import ru.isko.repositories.file_info.FileInfoRepository;
import ru.isko.repositories.news.NewsRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * created by Iskander Valiev
 * on 11/23/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private FileStorageService storageService;

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Override
    public void addNews(MultipartFile file, NewsForm newsForm) {
        String imagePath = storageService.saveFile(file);
        FileInfo image = fileInfoRepository.findOneByStorageFileName(imagePath);

        News news = News.builder()
                .header(newsForm.getHeader())
                .content(newsForm.getContent())
                .date(new java.sql.Date(System.currentTimeMillis()))
                .image(image)
                .type(newsForm.getType())
                .build();
        newsRepository.save(news);
    }

    @Override
    public List<News> sortNews(List<News> news) {
        news.sort(new NewsDateComparator());
        return news;
    }

    @Override
    public List<News> getLastNews() {
        List<News> news = newsRepository.findByType("News");
        news.sort(new NewsDateComparator());

        if (news.size() > 5) {
            List<News> lastNews = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                lastNews.add(news.get(i));
            }
            return lastNews;
        }
        return news;
    }
}
