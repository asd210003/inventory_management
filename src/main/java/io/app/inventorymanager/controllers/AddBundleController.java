package io.app.inventorymanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddBundleController {
    @RequestMapping("/addBundle")
    public String addBundle() {
        return "addbundle";
    }
}
