package com.miniapp.cardealer.controllers;

import com.miniapp.cardealer.entities.Supplier;
import com.miniapp.cardealer.models.viewModels.SupplierView;
import com.miniapp.cardealer.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("local")
    public String getLocalSuppliers(Model model){

        List<SupplierView> supplierViews = supplierService.getAllByImporter(false);
        model.addAttribute("suppliers", supplierViews);
        model.addAttribute("view", "/suppliers/suppliers-table");

        return "base-layout";
    }

    @GetMapping("importers")
    public String getImporters(Model model){

        List<SupplierView> supplierViews = supplierService.getAllByImporter(true);
        model.addAttribute("suppliers", supplierViews);
        model.addAttribute("view", "/suppliers/suppliers-table");

        return "base-layout";
    }


}
