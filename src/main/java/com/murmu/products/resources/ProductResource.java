package com.murmu.products.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @GetMapping
    public String get(){
        return "Hola Mundo";
    }
}
