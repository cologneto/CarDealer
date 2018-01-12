package com.miniapp.cardealer.controllers;

import com.miniapp.cardealer.models.viewModels.CarView;
import com.miniapp.cardealer.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("all")
    public String getCarsTablePage(Model model, @RequestParam(value = "make",required = false) String make){
        List<CarView> carInfoViews = this.carService.getAll();
        model.addAttribute("cars", carInfoViews);
        model.addAttribute("view","/cars/all-cars");
        return "base-layout";
    }
    @GetMapping("all/{make}")
    public String getCarsByMake(Model model,  @PathVariable String make){
        List<CarView> carInfoViews = this.carService.getByMake(make);
        model.addAttribute("cars", carInfoViews);
        model.addAttribute("view","/cars/all-cars");
        return "base-layout";
    }
}
