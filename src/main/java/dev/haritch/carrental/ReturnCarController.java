package dev.haritch.carrental;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/warehouse")
public class ReturnCarController {

    private final WarehouseRepository repository;
    private final RestTemplate restTemplate;
    private final StorefrontUrlConfig storefrontUrl;
     
    public ReturnCarController(WarehouseRepository repository, RestTemplate restTemplate, StorefrontUrlConfig storefrontUrl){
        this.repository = repository; //ใช้เข้าถึงฐานข้อมูล
        this.restTemplate = restTemplate;
        this.storefrontUrl = storefrontUrl;
    }

    @GetMapping("/returncar")
    public String searchCar() {
        String storefrontSearchUrl = "http://localhost:8080/car/all";
        String returnCarInfo = restTemplate.getForObject(storefrontSearchUrl, String.class);
        return "Search completed and storefront responded: " + returnCarInfo;
    }
    
}
