package az.kapitalbank.bffumico.controller;

import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import az.kapitalbank.bffumico.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/marketplace/order")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderController {

    OrderService service;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequestDto request) {
        return ResponseEntity.ok(service.createOrder(request));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteOrder(@RequestParam String trackId) {
        return ResponseEntity.ok(service.deleteOrder(trackId));
    }
}
