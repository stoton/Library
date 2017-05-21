package com.github.stoton.controllers.articles;

import com.github.stoton.domain.Article;
import com.github.stoton.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("/getAll")
    public String getAllArticle(Model model, ArticleForm articleForm) {
        model.addAttribute("list", articleRepository.getAll());
        return "welcome";
    }

    @GetMapping("/addArticle")
    public String displayArticle(Model model, ArticleForm articleForm) {
        model.addAttribute("list", articleRepository.getAll());
        return "/addArticle";
    }


    @PostMapping("/addArticle")
    public String addArticle(ArticleForm articleForm) {
        Article article = articleForm.convertToArticle();

        try {
            articleRepository.save(article);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "redirect:/";
    }

}
