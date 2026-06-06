package io.app.inventorymanager.controllers;

import io.app.inventorymanager.entities.Bundle;
import io.app.inventorymanager.entities.Product;
import io.app.inventorymanager.services.BundleService;
import io.app.inventorymanager.services.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomePageController {

    private final BundleService bundleService;
    private final ProductService productService;

    public HomePageController(BundleService bundleService, ProductService productService) {
        this.bundleService = bundleService;
        this.productService = productService;
    }
    @GetMapping("/homepage")
    public String homePage(Model model) {
        List<Product> products = productService.listProducts();
        model.addAttribute("products", products);
        List<Bundle> bundles = bundleService.listBundles();
        model.addAttribute("bundles", bundles);
        return "homepage";
    }

    @GetMapping("/")
    public String redirectToHomePage() {
        return "redirect:/homepage";
    }

    @GetMapping("/searchProductAndBundle")
    public String searchProduct(@RequestParam(defaultValue = "", name = "productKeyword") String productKeyword, @RequestParam
            (defaultValue = "", name = "bundleKeyword") String bundleKeyword, Model model) {

        List<Product> products = productService.searchProducts(productKeyword);
        model.addAttribute("products", products);
        List<Bundle> bundles = bundleService.searchBundles(bundleKeyword);
        model.addAttribute("bundles", bundles);
        model.addAttribute("productKeyword", productKeyword);
        model.addAttribute("bundleKeyword", bundleKeyword);

        return "homepage";
    }

}
