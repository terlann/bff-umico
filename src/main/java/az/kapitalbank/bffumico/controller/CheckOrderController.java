package az.kapitalbank.bffumico.controller;

import az.kapitalbank.bffumico.service.CheckOrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/marketplace/order/check")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CheckOrderController {

    CheckOrderService service;

    @PostMapping
    public ResponseEntity<?> checkOrder(@RequestParam("eteOrderId") String eteOrderId) {
        return ResponseEntity.ok(service.checkOrder(eteOrderId));
    }

}