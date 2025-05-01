package dev.haritch.carrental;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/warehouse")
public class CustomerActionController {

    private final WarehouseRepository repository;
    private final RestTemplate restTemplate;
    private final StorefrontUrlConfig storefrontUrl;

    public CustomerActionController(WarehouseRepository repository, RestTemplate restTemplate, StorefrontUrlConfig storefrontUrl) {
        this.repository = repository; //ใช้เข้าถึงฐานข้อมูล
        this.restTemplate = restTemplate;
        this.storefrontUrl = storefrontUrl;
    }

    @PutMapping("/sendcar/{licensePlate}")
    public ResponseEntity<String> sendCarStatus(@PathVariable String licensePlate) {
        Optional<CarStorage> targetCarLicense = repository.findByLicensePlate(licensePlate);

        if(targetCarLicense.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
        }

        CarStorage targetCar = targetCarLicense.get();

        if(!"Customer not showup".equalsIgnoreCase(targetCar.getCarStatus())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Car is not marked as 'customer not show up'");
        }

        List<CarStorage> avaiableCars = repository.findByCarTypeAndCarStatus(targetCar.getCarType(), "not Rental");

        if(avaiableCars.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No avaiable car of same type found");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        for(CarStorage car : avaiableCars){
            Map<String, Object> body = new HashMap<>();
            body.put("licensePlate", car.getLicensePlate());
            body.put("carType", car.getCarType());
            body.put("carStatus", car.getCarStatus());

            String url = "http://localhost:8080/order/edit" + car.getLicensePlate();

            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(body, headers);
            try{
                restTemplate.put(url, requestEntity);
            } catch (Exception e){
                System.err.println("Error sending car " + car.getLicensePlate() + ": " + e.getMessage());
            }
        }
        return ResponseEntity.ok("Sent avaiable cars of same type to storefront");
    } 

}
