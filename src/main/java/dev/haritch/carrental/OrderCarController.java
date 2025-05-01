package dev.haritch.carrental;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/warehouse")
public class OrderCarController {

    private final WarehouseRepository repository;
    private final RestTemplate restTemplate;
    private final StorefrontUrlConfig storefrontUrl;
     
    public OrderCarController(WarehouseRepository repository, RestTemplate restTemplate, StorefrontUrlConfig storefrontUrl){
        this.repository = repository; //ใช้เข้าถึงฐานข้อมูล
        this.restTemplate = restTemplate;
        this.storefrontUrl = storefrontUrl;
    }

    @PostMapping("/ordercar/{licensePlate}")
    public ResponseEntity<String> handleOrder(@PathVariable String licensePlate) {
        Optional<CarStorage> orderByLicense = repository.findByLicensePlate(licensePlate);

        //อาจจะทำให้
        if (orderByLicense.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
        }

        CarStorage car = orderByLicense.get();
        //String url = storefrontUrl.getOrderCar() + "order/edit/" + licensePlate;
        String url = "http://localhost:8080/order/edit/"+licensePlate;

        //if รถเสียค่อยอัปเดท
        restTemplate.put(url, car.getCarStatus());


        return ResponseEntity.ok("Car sent to storefront" + car.getLicensePlate() + "Status: " + car.getCarStatus());
    }  
}    
