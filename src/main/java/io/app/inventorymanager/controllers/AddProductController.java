package io.app.inventorymanager.controllers;

import io.app.inventorymanager.entities.Product;
import io.app.inventorymanager.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddProductController {

    private final ProductService productService;

    public AddProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "addproduct";
    }

    @PostMapping("/addProduct")
    public String submitProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "confirmproduct";
    }
}
