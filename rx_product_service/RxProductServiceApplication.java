package com.example.rx_product_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RxProductServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(RxProductServiceApplication.class, args);


		ObservableObserver observableObserver = new ObservableObserver();
		observableObserver.fetchObservable();

		observableObserver.fetchSingleObservable();

		observableObserver.fetchMaybeObservable();

		observableObserver.createObservableFromCreate().subscribe(System.out::println);
	}

}
