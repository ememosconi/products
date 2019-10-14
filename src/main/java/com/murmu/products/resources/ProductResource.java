package com.murmu.products.resources;

import com.murmu.products.model.Product;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @GetMapping
    public String get(){
        return "Hola Mundo";
    }

    @GetMapping("/{productId}")
    public String get(@PathVariable("productId") Long productId,
                      @RequestParam(value="filter", required = false) String filter){
        return "El id de producto es "+ productId + "y esta filtrado por" + filter;
    }


    @PostMapping
    public @ResponseBody  String save(@Valid @RequestBody Product body){
        return body.getName();
    }

    @PutMapping("/{productId}")
    public @ResponseBody String update(@PathVariable("productId") Long productId,
                  @Valid @RequestBody Product body){

        return "vamos a actualizar el producto: " + productId + "con" +body.toString();

    }

    @DeleteMapping("/{productId}")
    public @ResponseBody String delete(@PathVariable("productId") Long productId){
        return "vamos a eliminar el producto " + productId;
    }

}
