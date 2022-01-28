package az.kapitalbank.bffumico.controller;

import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import az.kapitalbank.bffumico.dto.request.PurchaseRequestDto;
import az.kapitalbank.bffumico.dto.request.ReverseRequestDto;
import az.kapitalbank.bffumico.dto.response.CheckOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.CreateOrderResponseDto;
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
@RequestMapping("/api/v1/orders")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderController {

    OrderService service;

    @PostMapping
    public ResponseEntity<CreateOrderResponseDto> createOrder(@RequestBody CreateOrderRequestDto request) {
        return service.createOrder(request);
    }

    @PostMapping("/reverse")
    public ResponseEntity<Void> reverseOrder(@RequestBody ReverseRequestDto request) {
        return service.reverseOrder(request);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteOrder(@RequestParam String trackId) {
        return service.deleteOrder(trackId);
    }

    @PostMapping("/check")
    public ResponseEntity<CheckOrderResponseDto> checkOrder(@RequestParam("eteOrderId") String eteOrderId) {
        return service.checkOrder(eteOrderId);
    }

    @PostMapping("/purchase")
    public ResponseEntity<Void> purchase(@RequestBody PurchaseRequestDto request) {
        return service.purchase(request);
    }

}
