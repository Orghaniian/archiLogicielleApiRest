package com.example.archiLogicielleApiRest;

import com.example.archiLogicielleApiRest.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
