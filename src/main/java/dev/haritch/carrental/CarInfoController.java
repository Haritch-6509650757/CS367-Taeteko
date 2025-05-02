package dev.haritch.carrental;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/warehouse")
public class CarInfoController {

    private final RestTemplate restTemplate;
    private final WarehouseRepository repository;

    public CarInfoController(RestTemplate restTemplate, WarehouseRepository repository) {
        this.restTemplate = restTemplate;
        this.repository = repository;
    }

    @GetMapping("/info/storefront")
    public ResponseEntity<?> getOrderByCarPlateStorefront(@RequestParam(required = false) String carPlateNumber) {
        if (carPlateNumber == null || carPlateNumber.isEmpty()) {
            return ResponseEntity.badRequest().body("Please enter your car plate number.");
        }

        String url = "http://localhost:8080/order/info?carPlateNumber=" + carPlateNumber;

        try {
            ResponseEntity<?> response = restTemplate.getForEntity(url, Object.class);
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Car not found: " + carPlateNumber);
        }
    }

    @GetMapping("/info")
    public ResponseEntity<?> getOrderByCarPlate(@RequestParam(required = false) String carPlateNumber) {
        if (carPlateNumber == null || carPlateNumber.isEmpty()) {
            return ResponseEntity.badRequest().body("Please enter your car plate number.");
        }
        return repository.findByLicensePlate(carPlateNumber)
                .map(order -> ResponseEntity.ok(order))
                .orElseGet(() -> ResponseEntity.status(404).body(null));
    }
}
