package com.example.rx_product_service.controller;

import com.example.rx_product_service.entity.Product;
import com.example.rx_product_service.service.ProductService;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rxproduct")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path="/all")
    public Observable<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping()
    public Single<Product> getProductByID(@RequestParam  Long id){
        return productService.getProductById(id);
    }

    @PostMapping("/save")
    public Single<Product> saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public Maybe<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public Completable deleteProduct(@PathVariable Long id) {
        return productService.deleteProdcut(id);
    }
}
