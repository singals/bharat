package com.shashank.bharat.debtors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public ModelAndView addDebtor(Debtor debtor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return new ModelAndView("debtors/add");
        }
        debtorsRepository.save(debtor);

        model.addAttribute("debtors", debtorsRepository.findAll());
        return new ModelAndView("/debtors/display-all");
    }
}
