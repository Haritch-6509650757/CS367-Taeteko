package com.example.carrentalstore;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/all")
    public List<CarStorage> getAllCars() {
        return carRepository.findByReadyToReturn(true);
    }

    @GetMapping("/{id}")
    public Optional<CarStorage> getCarById(@PathVariable Long id) {
        return carRepository.findById(id);
    }
}
