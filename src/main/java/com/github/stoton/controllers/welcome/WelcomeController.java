package com.github.stoton.controllers.welcome;

import com.github.stoton.domain.Article;
import com.github.stoton.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WelcomeController {

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "");
        return "welcome";
    }

    @RequestMapping("/howToStart")
    public String howToStart(Model model) {
        return "howToStart";
    }

    @RequestMapping("/statute")
    public String statute(Model model) {
        return "statute";
    }

    @RequestMapping("/aboutAuthor")
    public String aboutAuthor(Model model) {
        return "aboutAuthor";
    }

    @RequestMapping("/{number:\\d+}")
    public String selectPage(@PathVariable(value = "number", required = false) int number, Model model) {

        if(number == 0) number = 1;
        if(number > 1) {
            String num = Integer.toString(number-1);
            model.addAttribute("previous", num);
        }

        List<Article> listOfArticles = articleRepository.getAll();

        int countOfPages = listOfArticles.size() % 2 == 0 ? (listOfArticles.size() / 2) : (listOfArticles.size() / 2 +1);

        int i = listOfArticles.size();
        for(Article a : listOfArticles) {
            a.setId(i);
            i--;
        }


        if(number < countOfPages) {
            String num = Integer.toString(number+1);
            model.addAttribute("next", num);
        }

        int start = number*2-2;
        int end = start + 2;


        List<Article> listAfterFiltering = listOfArticles.stream()
                .filter(article -> article.getId() > start && article.getId() <=  end)
                .collect(Collectors.toList());

        Collections.reverse(listAfterFiltering);
        model.addAttribute("list", listAfterFiltering);

        return "welcome";
    }
}
