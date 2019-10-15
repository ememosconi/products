package com.murmu.products.repositories;

import com.murmu.products.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRespository extends CrudRepository<Product,Long> {
}
