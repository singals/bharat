package com.shashank.bharat.debtors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/debtors")
public class DebtorsController {

    @Autowired
    private DebtorsRepository debtorsRepository;

    @GetMapping
    public ModelAndView getAllDebtors(Model model) {
        model.addAttribute("debtors", debtorsRepository.findAll());
        return new ModelAndView("debtors/display-all");
    }
}
