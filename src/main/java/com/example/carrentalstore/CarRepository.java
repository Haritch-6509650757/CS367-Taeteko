package com.example.carrentalstore;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarStorage, Long>{
    List<CarStorage> findByReadyToReturn(boolean readyToReturn);
}