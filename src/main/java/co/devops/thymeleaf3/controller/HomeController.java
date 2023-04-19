package co.devops.thymeleaf3.controller;

import co.devops.thymeleaf3.model.Article;
import co.devops.thymeleaf3.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class HomeController {
    private final ArticleService service;

    public HomeController(ArticleService service) {
        this.service = service;
    }

    @GetMapping("/home")
    String viewHome(Model model){
        List<Article> articleList=service.getAllArticle();
        model.addAttribute("articles",articleList);
        return "pages/index";
    }
}
