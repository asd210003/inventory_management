package io.app.inventorymanager.controllers;

import io.app.inventorymanager.entities.Bundle;
import io.app.inventorymanager.entities.Product;
import io.app.inventorymanager.services.BundleService;
import io.app.inventorymanager.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("bundle")
@RequestMapping("/addBundle")
public class AddBundleController {

    private final BundleService bundleService;
    private final ProductService productService;

    public AddBundleController(BundleService bundleService, ProductService productService) {
        this.bundleService = bundleService;
        this.productService = productService;
    }

    @GetMapping
    public String addBundle(Model model) {
        model.addAttribute("bundle", new Bundle());
        return "addbundle";
    }

    @GetMapping("/back")
    public String back(@ModelAttribute("bundle") Bundle bundle, Model model) {
        model.addAttribute("bundle", bundle);
        return "addbundle";
    }

    @PostMapping
    public String addBundle(
            @Valid @ModelAttribute("bundle") Bundle bundle,
            BindingResult result) {

        if (result.hasErrors()) {
            return "addbundle";
        }
        bundleService.saveBundle(bundle);

        return "redirect:/addBundle/addBundleProducts";
    }

    @GetMapping("/addProducts")
    public String addProducts(@RequestParam("id") Long id, Model model, @ModelAttribute("bundle") Bundle bundle) {
        Product product = productService.getProductById(id).get();
        bundle.getProducts().add(product);
        List<Product> products = productService.listProducts();
        products.removeIf(p -> bundle.getProducts().contains(p));
        products.removeIf(p -> bundle.getQuantity() > p.getQuantity());
        model.addAttribute("products", products);
        model.addAttribute("productsAdded", bundle.getProducts());
        return "addbundleproducts";
    }

    @GetMapping("/removeProducts")
    public String removeProducts(@RequestParam("id") Long id, Model model, @ModelAttribute("bundle") Bundle bundle) {
        Product product = productService.getProductById(id).get();
        bundle.getProducts().remove(product);
        List<Product> products = productService.listProducts();
        products.removeIf(p -> bundle.getProducts().contains(p));
        products.removeIf(p -> bundle.getQuantity() > p.getQuantity());
        model.addAttribute("products", products);
        model.addAttribute("productsAdded", bundle.getProducts());
        return "addbundleproducts";

    }

    @GetMapping("/addBundleProducts")
    public String addBundleProducts(Model model, @ModelAttribute("bundle") Bundle bundle) {
        model.addAttribute("bundle", bundle);
        List<Product> products = productService.listProducts();
        products.removeIf(product -> bundle.getProducts().contains(product));
        products.removeIf(product -> bundle.getQuantity() > product.getQuantity());
        model.addAttribute("products", products);
        model.addAttribute("productsAdded", bundle.getProducts());
        return "addbundleproducts";
    }

    @PostMapping("/addBundleProducts")
    public String updateBundleProducts(@ModelAttribute("bundle") Bundle bundle) {
        bundleService.updateBundle(bundle);
        return "confirmbundle";
    }

    @GetMapping("/cancelBundle")
    public String cancelBundle(@RequestParam("id") Long id) {
        if (bundleService.getBundleById(id).isPresent()) {
            bundleService.deleteById(id);
        }
        return "redirect:/homepage";
    }
}
