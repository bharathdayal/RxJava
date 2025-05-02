package com.example.rx_product_service.service;

import com.example.rx_product_service.entity.Product;
import com.example.rx_product_service.repositories.ProductRepository;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Observable<Product> getAllProduct() {
        return Observable.fromIterable(productRepository.findAll());
    }

    public Single<Product> getProductById(Long id) {
        return Single.create(emitter -> {
            Product product = productRepository.findById(id).orElse(null);
            if (product != null) {
                emitter.onSuccess(product);
            } else {
                emitter.onError(new RuntimeException("Not Found"));
            }

        });
    }

        public Single<Product> saveProduct(Product product) {
            return Single.fromCallable(()->productRepository.save(product));

        }

        public Completable deleteProdcut(Long id) {
            return Completable.fromRunnable(()->productRepository.deleteById(id));
        }

        public Maybe<Product> updateProduct(Long id,Product product) {
            return Maybe.create(emitter -> {
                if (productRepository.existsById(id)) {
                    product.setId(id);
                    emitter.onSuccess(productRepository.save(product));
                } else {
                    emitter.onComplete(); // return empty
                }
            });
        }


}
