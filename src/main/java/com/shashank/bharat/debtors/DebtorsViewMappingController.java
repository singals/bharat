package com.shashank.bharat.debtors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DebtorsViewMappingController {

    @Autowired
    private DebtorsRepository debtorsRepository;

    @RequestMapping("debtors/add")
    public ModelAndView addDebtor(Debtor debtor) {
        return new ModelAndView("debtors/add");
    }

    @RequestMapping("delete-debtor/{id}")
    public ModelAndView deleteArticle(@PathVariable Long id, Model model) {
        debtorsRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid debtor Id:" + id));
        debtorsRepository.deleteById(id);

        model.addAttribute("debtors", debtorsRepository.findAll());
        return new ModelAndView("/debtors/display-all");
    }

    @RequestMapping("edit-debtor/{id}")
    public ModelAndView editArticle(@PathVariable Long id, Model model) {
        Debtor debtor = debtorsRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid debtor Id:" + id));
        model.addAttribute("debtor", debtor);

        return new ModelAndView("/debtors/edit");
    }
}
