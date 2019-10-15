package com.murmu.products.services;

import com.murmu.products.model.Product;
import com.murmu.products.repositories.ProductRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRespository productRespository;

    public ProductService(ProductRespository productRespository){
        this.productRespository = productRespository;
    }


    public List<Product> get(){



        return (List<Product>) productRespository.findAll();
    }

    public Product get(Long productId){

        Optional<Product> resultOptional = productRespository.findById(productId);

        Product result = null;

        if(resultOptional.isPresent()){

            result = resultOptional.get();
        }

        return result;

    }

    public Product save(Product product){

       return productRespository.save(product);
    }

    public Product update(Long productId,Product product){
        Optional<Product> optionalProduct = productRespository.findById(productId);

        Product result = null;

        if(optionalProduct.isPresent()){
            Product productBack = optionalProduct.get();
            productBack.setDescription(product.getDescription());
            productBack.setName(product.getName());
            productBack.setPrice(product.getPrice());
            result = productRespository.save(productBack);
        }

        return  result;
    }

    public void delete(Long productId){
        Optional<Product> productToDelete = productRespository.findById(productId);

        if(productToDelete.isPresent()){
            productRespository.delete(productToDelete.get());
        }
    }
}
