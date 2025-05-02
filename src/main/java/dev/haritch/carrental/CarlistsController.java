package dev.haritch.carrental;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/warehouse")
public class CarlistsController {
    private final WarehouseRepository repository;
    private final RestTemplate restTemplate;
     
    public CarlistsController(WarehouseRepository repository, RestTemplate restTemplate){
        this.repository = repository; //ใช้เข้าถึงฐานข้อมูล
        this.restTemplate = restTemplate;
    }

    @GetMapping("/carlists")
    public List<CarStorage> listAllCars(){
        return repository.findByCarStatus("not Rental");
    }
}
