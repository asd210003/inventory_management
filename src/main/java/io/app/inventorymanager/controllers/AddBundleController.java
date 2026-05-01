package io.app.inventorymanager.controllers;

import io.app.inventorymanager.entities.Bundle;
import io.app.inventorymanager.services.BundleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddBundleController {

    private final BundleService bundleService;

    public AddBundleController(BundleService bundleService) {
        this.bundleService = bundleService;
    }

    @GetMapping("/addBundle")
    public String addBundle(Model model) {
        Bundle bundle = new Bundle();
        model.addAttribute("bundle", bundle);
        return "addbundle";
    }

    @PostMapping("/addBundle")
    public String submitBundle(@ModelAttribute("bundle") Bundle bundle) {
        bundleService.saveBundle(bundle);
        return "confirmbundle";
    }

}
