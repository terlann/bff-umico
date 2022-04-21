package az.kapitalbank.bffumico.controller;

import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import az.kapitalbank.bffumico.dto.request.PurchaseRequestDto;
import az.kapitalbank.bffumico.dto.request.RefundRequestDto;
import az.kapitalbank.bffumico.dto.request.TelesalesResultRequestDto;
import az.kapitalbank.bffumico.dto.response.CheckOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.CreateOrderResponseDto;
import az.kapitalbank.bffumico.service.OrderService;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<CreateOrderResponseDto> createOrder(
            @RequestBody CreateOrderRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PostMapping("/refund")
    @ApiOperation("Order Cancellation (UNBLOCK) Refund Amount")
    public ResponseEntity<Void> refund(@RequestBody RefundRequestDto request) {
        service.refund(request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/check/{telesales-order-id}")
    @ApiOperation(value = "Telesales order check")
    public ResponseEntity<CheckOrderResponseDto> checkOrder(
            @PathVariable("telesales-order-id") String telesalesOrderId) {
        return ResponseEntity.ok(service.check(telesalesOrderId));
    }

    @PostMapping("/purchase")
    @ApiOperation("Order Delivery")
    public ResponseEntity<Void> purchase(
            @RequestBody PurchaseRequestDto request) {
        service.purchase(request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/telesales/result")
    @ApiOperation(value = "telesales order result")
    public ResponseEntity<Void> telesalesResult(@RequestBody TelesalesResultRequestDto request) {
        service.telesalesResult(request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
