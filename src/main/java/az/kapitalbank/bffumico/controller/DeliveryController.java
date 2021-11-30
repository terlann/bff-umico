package az.kapitalbank.bffumico.controller;

import az.kapitalbank.bffumico.dto.request.DeliveryProductRequestDto;
import az.kapitalbank.bffumico.service.DeliveryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/marketplace/delivery")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DeliveryController {

    DeliveryService service;

    @PostMapping
    public ResponseEntity<?> deliveryProducts(@RequestBody DeliveryProductRequestDto request) {
        return service.deliveryProducts(request);
    }
}
