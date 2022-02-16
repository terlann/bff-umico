package az.kapitalbank.bffumico.controller;

import java.util.List;

import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import az.kapitalbank.bffumico.dto.request.PurchaseRequestDto;
import az.kapitalbank.bffumico.dto.request.ReverseRequestDto;
import az.kapitalbank.bffumico.dto.response.CheckOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.CreateOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.PurchaseResponseDto;
import az.kapitalbank.bffumico.service.OrderService;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<PurchaseResponseDto> reverseOrder(@RequestBody ReverseRequestDto request) {
        return service.reverseOrder(request);
    }

    @PostMapping("/check/{telesalesOrderId}")
    @ApiOperation(value = "Order Delivery", hidden = true)
    public ResponseEntity<CheckOrderResponseDto> checkOrder(@PathVariable("telesalesOrderId") String telesalesOrderId) {
        return service.checkOrder(telesalesOrderId);
    }

    @PostMapping("/purchase")
    @ApiOperation("Order Delivery")
    public ResponseEntity<List<PurchaseResponseDto>> purchase(@RequestBody PurchaseRequestDto request) {
        return service.purchase(request);
    }

}
