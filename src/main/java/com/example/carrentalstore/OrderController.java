package com.example.carrentalstore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/save")
    public String orderCar(@RequestBody OrderStorage order) {
        orderRepository.save(order);
        String text = externalController.orderCar(order.getCarPlateNumber());
        return "บันทึกลงฐานข้อมูลเรียบร้อย: " + order.toString() + "\n" + text;
    }


    @PutMapping("/edit/{carPlateNumber}")
    public String editOrderByCarPlate(@RequestBody Map<String, String> request, @PathVariable String carPlateNumber) {
        return orderRepository.findByCarPlateNumber(carPlateNumber)
        .map(order -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = LocalDateTime.now().format(formatter);
            String status = request.get("carStatus");
            String remake = request.get("remark");
            order.setRemarks(remake);
            order.setStatus(status);
            order.setLastUpdated(formattedDate);
            orderRepository.save(order);
            return "แก้ไขสถานะสำเร็จ: " + carPlateNumber;
        })
        .orElse("ไม่พบข้อมูล: " + carPlateNumber);
    }

}
