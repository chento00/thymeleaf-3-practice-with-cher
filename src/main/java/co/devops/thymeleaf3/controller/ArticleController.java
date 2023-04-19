package co.devops.thymeleaf3.controller;

import co.devops.thymeleaf3.model.Article;
import co.devops.thymeleaf3.service.ArticleService;
import co.devops.thymeleaf3.service.FileUploadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService service;
    private final FileUploadService fileUploadService;

    @GetMapping("/article")
    String viewArticle(Model model){
        List<Article> articleList=service.getAllArticle();
        model.addAttribute("articles",articleList);
        return "pages/article-page";
    }
    @GetMapping("/article/new")
    String vewArticleNew( Article article,Model model){
        model.addAttribute("article",article);
        return "pages/article-new";
    }
    @PostMapping("/article/new")
    String doSaveArticle(@ModelAttribute @Valid Article article,
                         BindingResult result,
                         @RequestParam("thumbnail") MultipartFile file,
                         Model model){
        if(result.hasErrors()){
            model.addAttribute("article",article);
            return "pages/article-new";
        }
        service.save(article,file);
        System.out.println(file.getOriginalFilename());
        return "redirect:/article/new";
    }
}
