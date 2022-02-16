package az.kapitalbank.bffumico.service;

import java.util.List;

import az.kapitalbank.bffumico.client.ordermarketplace.OrderMarketplaceClient;
import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import az.kapitalbank.bffumico.dto.request.PurchaseRequestDto;
import az.kapitalbank.bffumico.dto.request.ReverseRequestDto;
import az.kapitalbank.bffumico.dto.response.CheckOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.CreateOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.PurchaseResponseDto;
import az.kapitalbank.bffumico.mapper.OrderMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderService {

    OrderMarketplaceClient orderMarketplaceClient;
    OrderMapper orderMapper;

    public ResponseEntity<CreateOrderResponseDto> createOrder(CreateOrderRequestDto request) {
        var createOrderRequest = orderMapper.toCreateOrderRequest(request);
        var createOrderResponse = orderMarketplaceClient.createOrder(createOrderRequest);
        var createOrderResponseDto =
                orderMapper.toCreateOrderResponseDto(createOrderResponse.getBody());
        return ResponseEntity.status(createOrderResponse.getStatusCode()).body(createOrderResponseDto);
    }

    public ResponseEntity<CheckOrderResponseDto> checkOrder(String telesalesOrderId) {
        var checkOrderResponse = orderMarketplaceClient.checkOrder(telesalesOrderId);
        var checkOrderResponseDto =
                orderMapper.toCheckOrderResponseDto(checkOrderResponse.getBody());
        return ResponseEntity.status(checkOrderResponse.getStatusCode()).body(checkOrderResponseDto);
    }

    public ResponseEntity<PurchaseResponseDto> reverseOrder(ReverseRequestDto request) {
        var reverseRequest = orderMapper.toReverseRequest(request);
        var purchaseResponse = orderMarketplaceClient.reverseOrder(reverseRequest);
        var purchaseResponseDto = orderMapper.toPurchaseResponseDto(purchaseResponse.getBody());
        return ResponseEntity.status(purchaseResponse.getStatusCode()).body(purchaseResponseDto);
    }

    public ResponseEntity<List<PurchaseResponseDto>> purchase(PurchaseRequestDto request) {
        var purchaseRequest = orderMapper.toPurchaseRequest(request);
        var purchaseResponses = orderMarketplaceClient.purchase(purchaseRequest);
        var purchaseResponseDtoList =
                orderMapper.toPurchaseResponseDtoList(purchaseResponses.getBody());
        return ResponseEntity.status(purchaseResponses.getStatusCode()).body(purchaseResponseDtoList);
    }

}