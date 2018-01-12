package com.miniapp.cardealer.controllers;

import com.miniapp.cardealer.models.viewModels.CustomerView;
import com.miniapp.cardealer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    /*@GetMapping("all")
    @ResponseBody
    public String getHomePage(){
        return "HELLO";
    }*/

    @GetMapping("all")
    public String getHomePage(Model model, @RequestParam(value = "filter",required = false) String filter){
        List<CustomerView> customerViews = this.customerService.getAllOrderByBirthDate(filter);
        model.addAttribute("customers",customerViews);
        model.addAttribute("view","/customers/customers-table");
        return "base-layout";
    }
}
