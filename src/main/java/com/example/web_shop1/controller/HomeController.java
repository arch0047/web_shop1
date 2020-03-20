package com.example.web_shop1.controller;


import com.example.web_shop1.model.Product;
import com.example.web_shop1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @GetMapping
    public  String index(Model model)
    {
        // adding all product to view from productService
        model.addAttribute("productList", productService.readAll() ) ;
        return ("index");
    }

    @GetMapping("/create")
    public  String create()
    {
        return "create";

    }
    @PostMapping("/create")
    public String create(@ModelAttribute Product pdt)
    {
        productService.create(pdt);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {

        model.addAttribute("pdt", productService.read(id));
        return "update";
    }

    // Update product
    @PostMapping("/update")
    public String update(@ModelAttribute Product pdt){

        productService.update(pdt)
        ;
        return "redirect:/";
    }
 // Deleting products

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model){

        productService.delete(id);
        return "redirect:/";
    }


}
