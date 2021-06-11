package com.example.archiLogicielleApiRest;

import com.example.archiLogicielleApiRest.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/api/product")
    public long countProducts(){
        return productRepository.count();
    }

    @PostMapping("/api/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        if(product.isNotValid()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        product = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @DeleteMapping("/api/product/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") int id){
        if(productRepository.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        productRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/api/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
        if(productRepository.findById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(productRepository.findById(id).get());
    }

    @PutMapping("/api/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product){
        if(productRepository.findById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if(product.isNotValid()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        product.setId(id);
        product = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
