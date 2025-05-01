package com.example.carrentalstore;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarStorage, Long>{

}