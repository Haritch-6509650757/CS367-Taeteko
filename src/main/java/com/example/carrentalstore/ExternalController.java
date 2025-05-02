package com.example.carrentalstore;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/external")
public class ExternalController {

    private final RestTemplate restTemplate;
    private final String urlWarehouse = "http://localhost:9090";

    public ExternalController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/searchcar/available")
    public List<?> fetchCarWareHouse() {
        String url = urlWarehouse + "/warehouse/carlists";
        List<?> result = restTemplate.getForObject(url, List.class);
        return result;
    }

    @PostMapping("/ordercar")
    public ResponseEntity<String> orderCar(String licensePlate) {
        String url = urlWarehouse + "/warehouse/ordercar/" + licensePlate;
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, null, String.class);
        String text = "ส่งคำสั่งจัดหารถเรียบร้อย: " + licensePlate + "\n" + response.getBody();
        return ResponseEntity.ok(text);
    }

}
