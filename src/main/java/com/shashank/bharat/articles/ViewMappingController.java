package com.shashank.bharat.articles;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ViewMappingController{

    @RequestMapping("articles/add")
    public ModelAndView addArticle(Article article){
        return new ModelAndView("articles/add");
    }

}
