package az.kapitalbank.bffumico.controller;

import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import az.kapitalbank.bffumico.dto.request.PurchaseRequestDto;
import az.kapitalbank.bffumico.dto.request.ReverseRequestDto;
import az.kapitalbank.bffumico.dto.response.CheckOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.CreateOrderResponseDto;
import az.kapitalbank.bffumico.service.OrderService;
import io.swagger.annotations.ApiOperation;
import java.util.UUID;
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
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderController {

    OrderService service;

    @PostMapping
    @ApiOperation("All Transaction")
    public ResponseEntity<CreateOrderResponseDto> createOrder(@RequestBody CreateOrderRequestDto request) {
        return service.createOrder(request);
    }

    @PostMapping("/reverse")
    @ApiOperation("Order Cancellation (UNBLOCK) Reverse Amount")
    public ResponseEntity<Void> reverseOrder(@RequestBody ReverseRequestDto request) {
        return service.reverseOrder(request);
    }

    @DeleteMapping
    @ApiIgnore
    public ResponseEntity<Void> deleteOrder(@RequestParam UUID trackId) {
        return service.deleteOrder(trackId);
    }

    @PostMapping("/check")
    @ApiIgnore
    public ResponseEntity<CheckOrderResponseDto> checkOrder(@RequestParam("eteOrderId") String eteOrderId) {
        return service.checkOrder(eteOrderId);
    }

    @PostMapping("/purchase")
    @ApiOperation("Order Delivery")
    public ResponseEntity<Void> purchase(@RequestBody PurchaseRequestDto request) {
        return service.purchase(request);
    }

}
