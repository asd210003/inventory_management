package io.app.inventorymanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddProductController {

    @RequestMapping("/addProduct")
    public String addProduct() {
        return "addproduct";
    }
}
