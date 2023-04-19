package co.devops.thymeleaf3.service;

import co.devops.thymeleaf3.model.Article;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface ArticleService {
    List<Article> getAllArticle();
    boolean save(Article article, MultipartFile file);
}
