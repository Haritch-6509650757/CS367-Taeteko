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
                "AB1000", "Booked", "คุณสมชาย", "StoreA", "ต้องการส่งเร็ว", "2024-05-10", "2024-05-15", "2024-05-09"
            )));
            log.info("Preloading " + orderRepository.save(new OrderStorage(
                "ขค2345", "InProgress", "คุณสมหญิง", "StoreB", "โทรแจ้งก่อนส่ง", "2024-05-12", "2024-05-17", "2024-05-11"
            )));
            log.info("Preloading " + orderRepository.save(new OrderStorage(
                "PS1234", "Completed", "คุณประสงค์", "StoreC", "", "2024-04-20", "2024-04-25", "2024-04-25"
            )));
        };
    }

    //String brand, String plateNumber, Boolean readyToReturn
    @Bean
    CommandLineRunner initCarDatabase(CarRepository carRepository) {
        return args -> {
            log.info("Preloading " + carRepository.save(new CarStorage(
                "Toyota", "AB1000", true
            )));
            log.info("Preloading " + carRepository.save(new CarStorage(
                "Honda", "ขค2345", false
            )));
            log.info("Preloading " + carRepository.save(new CarStorage(
                "Nissan", "PS1234", true
            )));
        };
    }
}
