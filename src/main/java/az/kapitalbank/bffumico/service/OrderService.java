package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.OrderMarketplaceClient;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.TelesalesResultRequest;
import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import az.kapitalbank.bffumico.dto.request.PurchaseRequestDto;
import az.kapitalbank.bffumico.dto.request.ReverseRequestDto;
import az.kapitalbank.bffumico.dto.request.TelesalesResultRequestDto;
import az.kapitalbank.bffumico.dto.response.CheckOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.CreateOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.PurchaseResponseDto;
import az.kapitalbank.bffumico.mapper.OrderMapper;
import az.kapitalbank.bffumico.mapper.ScoringMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderService {

    OrderMapper orderMapper;
    ScoringMapper scoringMapper;
    OrderMarketplaceClient orderMarketplaceClient;

    public CreateOrderResponseDto createOrder(CreateOrderRequestDto request) {
        var createOrderRequest = orderMapper.toCreateOrderRequest(request);
        var createOrderResponse = orderMarketplaceClient.createOrder(createOrderRequest);
        return orderMapper.toCreateOrderResponseDto(createOrderResponse);
    }

    public CheckOrderResponseDto checkOrder(String telesalesOrderId) {
        var checkOrderResponse = orderMarketplaceClient.checkOrder(telesalesOrderId);
        return orderMapper.toCheckOrderResponseDto(checkOrderResponse);
    }

    public PurchaseResponseDto reverseOrder(ReverseRequestDto request) {
        var reverseRequest = orderMapper.toReverseRequest(request);
        var purchaseResponse = orderMarketplaceClient.reverseOrder(reverseRequest);
        return orderMapper.toPurchaseResponseDto(purchaseResponse);
    }

    public void purchase(PurchaseRequestDto request) {
        var purchaseRequest = orderMapper.toPurchaseRequest(request);
        orderMarketplaceClient.purchase(purchaseRequest);
    }

    public void telesalesResult(TelesalesResultRequestDto request) {
        TelesalesResultRequest orderRequest = scoringMapper.toScoringOrderRequest(request);
        orderMarketplaceClient.telesalesResult(orderRequest);
    }
}
