package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.OrderMarketplaceClient;
import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import az.kapitalbank.bffumico.dto.request.PurchaseRequestDto;
import az.kapitalbank.bffumico.dto.request.ReverseRequestDto;
import az.kapitalbank.bffumico.dto.response.CheckOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.CreateOrderResponseDto;
import az.kapitalbank.bffumico.mapper.OrderMapper;
import java.util.UUID;
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
        return ResponseEntity.ok(createOrderResponseDto);
    }

    public ResponseEntity<Void> deleteOrder(UUID trackId) {
        return orderMarketplaceClient.deleteOrder(trackId);
    }

    public ResponseEntity<CheckOrderResponseDto> checkOrder(String eteId) {
        var checkOrderResponse = orderMarketplaceClient.checkOrder(eteId);
        var checkOrderResponseDto =
                orderMapper.toCheckOrderResponseDto(checkOrderResponse.getBody());
        return ResponseEntity.ok(checkOrderResponseDto);
    }

    public ResponseEntity<Void> reverseOrder(ReverseRequestDto request) {
        var reverseRequest = orderMapper.toReverseRequest(request);
        return orderMarketplaceClient.reverseOrder(reverseRequest);
    }

    public ResponseEntity<Void> purchase(PurchaseRequestDto request) {
        var purchaseRequest = orderMapper.toPurchaseRequest(request);
        return orderMarketplaceClient.purchase(purchaseRequest);
    }

}