package io.app.inventorymanager.controllers;

import io.app.inventorymanager.entities.Bundle;
import io.app.inventorymanager.entities.Product;
import io.app.inventorymanager.services.BundleService;
import io.app.inventorymanager.services.ProductService;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomePageController {

    private BundleService bundleService;
    private ProductService productService;

    public HomePageController(BundleService bundleService, ProductService productService) {
        this.bundleService = bundleService;
        this.productService = productService;
    }
    @GetMapping("/")
    public String homePage(Model model) {
        List<Product> products = productService.listProducts();
        model.addAttribute("products", products);
        List<Bundle> bundles = bundleService.listBundles();
        model.addAttribute("bundles", bundles);
        return "homepage";
    }
}
