package com.murmu.products.resources;

import com.murmu.products.model.Product;
import com.murmu.products.services.ProductService;
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
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    private ProductService productService;

    public ProductResource(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> get(){
        return productService.get();
    }

    @GetMapping("/{productId}")
    public Product get(@PathVariable("productId") Long productId,
                      @RequestParam(value="filter", required = false) String filter){
        return productService.get(productId);
    }


    @PostMapping
    public @ResponseBody  Product save(@Valid @RequestBody Product body){
        return productService.save(body);
    }

    @PutMapping("/{productId}")
    public @ResponseBody Product update(@PathVariable("productId") Long productId,
                  @Valid @RequestBody Product body){

        return productService.update(productId,body);

    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable("productId") Long productId){
        productService.delete(productId);
    }

}
