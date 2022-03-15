package az.kapitalbank.bffumico.controller;

import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import az.kapitalbank.bffumico.dto.request.PurchaseRequestDto;
import az.kapitalbank.bffumico.dto.request.ReverseRequestDto;
import az.kapitalbank.bffumico.dto.request.TelesalesResultRequestDto;
import az.kapitalbank.bffumico.dto.response.CheckOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.CreateOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.PurchaseResponseDto;
import az.kapitalbank.bffumico.service.OrderService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createOrder(request));
    }

    @PostMapping("/reverse")
    @ApiOperation("Order Cancellation (UNBLOCK) Reverse Amount")
    public ResponseEntity<PurchaseResponseDto> reverseOrder(
            @RequestBody ReverseRequestDto request) {
        return ResponseEntity.ok(service.reverseOrder(request));
    }

    @PostMapping("/check/{telesales-order-id}")
    @ApiOperation(value = "Telesales order check")
    public ResponseEntity<CheckOrderResponseDto> checkOrder(
            @PathVariable("telesales-order-id") String telesalesOrderId) {
        return ResponseEntity.ok(service.checkOrder(telesalesOrderId));
    }

    @PostMapping("/purchase")
    @ApiOperation("Order Delivery")
    public ResponseEntity<List<PurchaseResponseDto>> purchase(
            @RequestBody PurchaseRequestDto request) {
        return ResponseEntity.ok(service.purchase(request));
    }

    @PostMapping("/telesales/result")
    @ApiOperation(value = "telesales order result")
    public ResponseEntity<Void> telesalesResult(@RequestBody TelesalesResultRequestDto request) {
        service.telesalesResult(request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
