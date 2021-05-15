package com.shashank.bharat.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ArticlesViewMappingController {

    @Autowired
    private ArticlesRepository articlesRepository;

    @RequestMapping("articles/add")
    public ModelAndView addArticle(Article article) {
        return new ModelAndView("articles/add");
    }

    @RequestMapping("delete-article/{id}")
    public ModelAndView deleteArticle(@PathVariable Long id, Model model) {
        articlesRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid article Id:" + id));
        articlesRepository.deleteById(id);

        model.addAttribute("articles", articlesRepository.findAll());
        return new ModelAndView("/articles/display-all");
    }

    @RequestMapping("edit-article/{id}")
    public ModelAndView editArticle(@PathVariable Long id, Model model) {
        Article article = articlesRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid article Id:" + id));
        model.addAttribute("article", article);

        return new ModelAndView("/articles/edit");
    }
}
