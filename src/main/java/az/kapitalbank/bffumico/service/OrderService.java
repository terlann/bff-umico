package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.MarketplaceClient;
import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import az.kapitalbank.bffumico.dto.request.PurchaseRequestDto;
import az.kapitalbank.bffumico.dto.request.RefundRequestDto;
import az.kapitalbank.bffumico.dto.request.TelesalesResultRequestDto;
import az.kapitalbank.bffumico.dto.response.CheckOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.CreateOrderResponseDto;
import az.kapitalbank.bffumico.mapper.OrderMapper;
import az.kapitalbank.bffumico.mapper.ScoringMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class OrderService {

    OrderMapper orderMapper;
    ScoringMapper scoringMapper;
    MarketplaceClient marketplaceClient;

    public CreateOrderResponseDto create(CreateOrderRequestDto request) {
        log.info("create order service started. request: {}", request);
        var response =
                marketplaceClient.create(orderMapper.toCreateOrderRequest(request));
        log.info("create order service ended. response: {}", response);
        return orderMapper.toCreateOrderResponseDto(response);
    }

    public CheckOrderResponseDto check(String telesalesOrderId) {
        log.info("check order service started. telesalesOrderId: {}", telesalesOrderId);
        var response = marketplaceClient.check(telesalesOrderId);
        log.info("check order service ended. response: {}", response);
        return orderMapper.toCheckOrderResponseDto(response);
    }

    public void refund(RefundRequestDto request) {
        log.info("refund service started. request: {}", request);
        marketplaceClient.refundOrder(orderMapper.toRefundRequest(request));
        log.info("refund service ended...");
    }

    public void purchase(PurchaseRequestDto request) {
        log.info("purchase service started. request: {}", request);
        marketplaceClient.purchase(orderMapper.toPurchaseRequest(request));
        log.info("purchase service ended...");
    }

    public void telesalesResult(TelesalesResultRequestDto request) {
        log.info("telesales result service started. request: {}", request);
        marketplaceClient.telesalesResult(scoringMapper.toScoringOrderRequest(request));
        log.info("telesales result service ended...");
    }
}
