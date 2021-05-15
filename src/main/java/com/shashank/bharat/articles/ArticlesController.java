package com.shashank.bharat.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

        model.addAttribute("articles", articlesRepository.findAll());
        return new ModelAndView("/articles/display-all");
    }

    @PostMapping("{id}")
    public ModelAndView updateArticle(Article article, BindingResult result, Model model, @PathVariable Long id) {
        articlesRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid article Id:" + id));

        if (result.hasErrors()) {
            model.addAttribute("articles", articlesRepository.findAll());
            return new ModelAndView("/articles/display-all");
        }

        articlesRepository.save(article);
        model.addAttribute("articles", articlesRepository.findAll());
        return new ModelAndView("/articles/display-all");
    }
}
