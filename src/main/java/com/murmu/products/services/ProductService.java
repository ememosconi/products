package com.murmu.products.services;

import com.murmu.products.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {


    public List<Product> get(){

        // aca hacemos la logica de negocio y la llamada a repositorios

        Product product1 = new Product();
        product1.setName("Samsung A7");
        product1.setDescription("Telefono Samsung A7");

        Product product2 = new Product();
        product2.setName("Moto G7 plus");
        product2.setDescription("Telefono Moto G7 plus");

        List<Product> result = new ArrayList<>();
        result.add(product1);
        result.add(product2);

        return result;
    }

    public Product get(Long productId){

        Product result;

        Product product1 = new Product();
        product1.setName("Samsung A7");
        product1.setDescription("Telefono Samsung A7");

        Product product2 = new Product();
        product2.setName("Moto G7 plus");
        product2.setDescription("Telefono Moto G7 plus");

        if(productId == 1L){

            result = product1;
        }
        else result = product2;

        result.setId(productId);
        return result;
    }

    public Product save(Product product){
       product.setId(1L);
       return product;
    }

    public Product update(Long productId,Product product){
        product.setId(productId);
        product.setDescription("Pase por una modificacion");
        return  product;
    }

    public Long delete(Long productId){
        return productId;
    }
}
