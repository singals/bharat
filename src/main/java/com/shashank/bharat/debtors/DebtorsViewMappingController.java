package com.shashank.bharat.debtors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DebtorsViewMappingController {

    @RequestMapping("debtors/add")
    public ModelAndView addDebtor(Debtor article) {
        return new ModelAndView("debtors/add");
    }
}
