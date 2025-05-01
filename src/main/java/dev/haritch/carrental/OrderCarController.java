package dev.haritch.carrental;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/warehouse")
public class OrderCarController {

    private final WarehouseRepository repository;
    private final RestTemplate restTemplate;
    private final StorefrontUrlConfig storefrontUrl;

    public OrderCarController(WarehouseRepository repository, RestTemplate restTemplate, StorefrontUrlConfig storefrontUrl) {
        this.repository = repository; //ใช้เข้าถึงฐานข้อมูล
        this.restTemplate = restTemplate;
        this.storefrontUrl = storefrontUrl;
    }

    @PutMapping("/ordercar/{licensePlate}")
    public ResponseEntity<String> handleOrder(@PathVariable String licensePlate) {
        Optional<CarStorage> orderByLicense = repository.findByLicensePlate(licensePlate);

        if (orderByLicense.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
        }

        CarStorage car = orderByLicense.get();
        String url = "http://localhost:8080/order/edit/" + licensePlate;

        Map<String, String> request = new HashMap<>();

        // ตรวจสอบสถานะของรถ
        if ("Broken".equals(car.getCarStatus())) {
            // หากรถเสีย ส่ง remark กลับไปยัง 8080
            request.put("remark", "Car is broken, customer rejected");
            restTemplate.put(url, request);
            return ResponseEntity.ok("Car is broken and sent back to storefront with remark.");
        } else if ("not Rental".equals(car.getCarStatus())) {
            // หากรถพร้อมจอง อัปเดตสถานะใน warehouse เป็น "จองแล้ว"
            car.setCarStatus("Rental");
            repository.save(car); // บันทึกสถานะใหม่ในฐานข้อมูล
            request.put("carStatus", car.getCarStatus());
            restTemplate.put(url, request);
            return ResponseEntity.ok("Car is ready and status updated to 'Booked'.");
        }

        // กรณีสถานะอื่น ๆ
        request.put("carStatus", car.getCarStatus());
        restTemplate.put(url, request);
        return ResponseEntity.ok("Car sent to storefront " + car.getLicensePlate() + " Status: " + car.getCarStatus());
    }

}
