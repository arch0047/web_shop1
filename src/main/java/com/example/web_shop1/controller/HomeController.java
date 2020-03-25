package com.example.web_shop1.controller;


import com.example.web_shop1.model.Product;
import com.example.web_shop1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
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
      //***********
    @RequestMapping(value = "/gem", method = RequestMethod.POST)
    public String save(@ModelAttribute("product") Product product)
    {
        productService.saveProduct(product);
        return "redirect:/prodctlist";
    }
     //************

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {

        model.addAttribute("pdt", productService.read(id));
        return "update";
    }

    // Update product
    @PostMapping("/update")
    public String update(@ModelAttribute Product pdt){
// calling service layer for update
        productService.update(pdt)
        ;
        // Back to the update page
        return "redirect:/";
    }
 // Deleting products

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){

        productService.delete(id);
        return "redirect:/";
    }


}
