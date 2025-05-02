package dev.haritch.carrental;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/warehouse")
public class ReturnCarController {

    private final WarehouseRepository repository;
    private final RestTemplate restTemplate;
     
    public ReturnCarController(WarehouseRepository repository, RestTemplate restTemplate){
        this.repository = repository; //ใช้เข้าถึงฐานข้อมูล
        this.restTemplate = restTemplate;
    }

    @GetMapping("/returncar")
    public Object searchCar(@RequestParam(required = false) Long id) {
        String url;
        if (id != null) {
            // ค้นหาตาม ID
            url = "http://localhost:8080/car/" + id;
            return restTemplate.getForObject(url, Object.class);
        } else {
            // แสดงรถทั้งหมด
            url = "http://localhost:8080/car/all";
            return restTemplate.getForObject(url, Object.class);
        }
    }
    
}
