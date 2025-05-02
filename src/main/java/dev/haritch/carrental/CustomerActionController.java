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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<String> sendCarStatus(@PathVariable String licensePlate, @RequestBody Map<String, String> request) {
        System.out.println("Received License Plate: " + licensePlate);

        Optional<CarStorage> targetCarLicense = repository.findByLicensePlate(licensePlate);

        if (targetCarLicense.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
        }

        CarStorage targetCar = targetCarLicense.get();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("licensePlate", targetCar.getLicensePlate());
        body.put("carType", targetCar.getCarType());
        body.put("carStatus", request.get("carStatus")); // ใช้ค่าจาก request
        body.put("remark", request.get("remark"));       // ใช้ค่าจาก request
        body.put("carBrand", targetCar.getCarBrand());

        String url = "http://localhost:8080/order/edit/" + targetCar.getLicensePlate();

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        try {
            restTemplate.put(url, requestEntity);
            return ResponseEntity.ok("แก้ไขสถานะสำเร็จ: " + licensePlate);
        } catch (Exception e) {
            System.err.println("Error sending car " + targetCar.getLicensePlate() + ": " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending car: " + e.getMessage());
        }
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Map<String, Object>>> getAllOrdersFromStorefront() {
        String url = "http://localhost:8080/order/all"; 
        try {
            ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            System.err.println("Error fetching orders: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
