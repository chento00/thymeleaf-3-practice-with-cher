package co.devops.thymeleaf3.service;

import co.devops.thymeleaf3.model.Article;
import co.devops.thymeleaf3.model.FileUpload;
import co.devops.thymeleaf3.repository.StaticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleServiceImp implements ArticleService{

    private final StaticRepository repository;
    private final FileUploadService uploadService;



    @Override
    public List<Article> getAllArticle() {
        return repository.getArticles();
    }

    @Override
    public boolean save(Article article, MultipartFile file) {
        FileUpload fileUpload=uploadService.uploadSingle(file);
        if(fileUpload.isSuccessed()){
            article.setUuid(UUID.randomUUID());
            article.setThumnail(fileUpload.filemame());
            repository.getArticles().add(0,article);
        }
        return false;
    }
}
