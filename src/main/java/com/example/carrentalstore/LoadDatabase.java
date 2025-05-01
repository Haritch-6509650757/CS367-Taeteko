package com.example.carrentalstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    //String carPlateNumber, String status, String customerName, String storeId, String remarks, String orderDate, String deliveryDate, String lastUpdated
    @Bean
    CommandLineRunner initOrderDatabase(OrderRepository orderRepository) {
        return args -> {
            
            log.info("Preloading " + orderRepository.save(new OrderStorage(
                "AB1000", "InProgress", "Somchai", "rental168", "-", "2025-03-13", "2025-03-15", "2025-03-15"
            )));
            log.info("Preloading " + orderRepository.save(new OrderStorage(
                "PS1234", "InProgress", "Somying", "rental168", "-", "2025-03-16", "2025-03-17", "2025-03-15"
            )));
            log.info("Preloading " + orderRepository.save(new OrderStorage(
                "KS9099", "InProgress", "Prapong", "rental168", "-", "2025-03-20", "2025-03-25", "2025-03-25"
            )));
        };
    }

    //String brand, String plateNumber, Boolean readyToReturn
    @Bean
    CommandLineRunner initCarDatabase(CarRepository carRepository) {
        return args -> {
            log.info("Preloading " + carRepository.save(new CarStorage(
                "Mercedes Benz", "XZ1234", true
            )));
            log.info("Preloading " + carRepository.save(new CarStorage(
                "Honda", "JX5000", false
            )));
        };
    }
}
