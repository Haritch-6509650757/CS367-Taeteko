package com.example.carrentalstore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;
    private final ExternalController externalController;

    @Autowired
    public OrderController(OrderRepository orderRepository, ExternalController externalController) {
        this.orderRepository = orderRepository;
        this.externalController = externalController;
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderStorage>> getAllOrders() {
        List<OrderStorage> orders = orderRepository.findAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getOrderByCarPlate(@RequestParam(required = false) String carPlateNumber) {
        if (carPlateNumber == null || carPlateNumber.isEmpty()) {
            return ResponseEntity.badRequest().body("Please enter your car plate number.");
        }
        return orderRepository.findByCarPlateNumber(carPlateNumber)
                .map(order -> ResponseEntity.ok(order))
                .orElseGet(() -> ResponseEntity.status(404).body(null));
    }

    @PostMapping("/save")
    public ResponseEntity<String> orderCar(@RequestBody OrderStorage order) {
        orderRepository.save(order);
        ResponseEntity<String> text = externalController.orderCar(order.getCarPlateNumber());
        String response = "Successfully saved to the database: " + order.toString() + "\n" + text;
        return ResponseEntity.ok(response);
    }

    @PutMapping("/edit/{carPlateNumber}")
    public ResponseEntity<String> editOrderByCarPlate(@RequestBody Map<String, String> request, @PathVariable String carPlateNumber) {
        return orderRepository.findByCarPlateNumber(carPlateNumber)
                .map(order -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String formattedDate = LocalDateTime.now().format(formatter);
                    String status = request.get("carStatus");
                    String remark = request.get("remark");
                    order.setRemarks(remark);
                    order.setStatus(status);
                    order.setLastUpdated(formattedDate);
                    orderRepository.save(order);
                    String response = "Status updated successfully: " + carPlateNumber;
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.status(404).body("No data found: " + carPlateNumber));
    }

}
