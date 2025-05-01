package com.example.carrentalstore;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderStorage, Long>{
    Optional<OrderStorage> findByCarPlateNumber(String carPlateNumber);
}