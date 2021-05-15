package com.shashank.bharat.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    @Autowired
    private ArticlesRepository articlesRepository;

    @GetMapping
    public ModelAndView getAllArticles(Model model) {
        model.addAttribute("articles", articlesRepository.findAll());
        return new ModelAndView("articles/display-all");
    }

    @PostMapping
    public ModelAndView addArticle(Article article, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return new ModelAndView("articles/add");
        }
        articlesRepository.save(article);
        return new ModelAndView("/articles/display-all");
    }
}
