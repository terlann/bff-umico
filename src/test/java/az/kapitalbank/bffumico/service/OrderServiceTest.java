package az.kapitalbank.bffumico.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import az.kapitalbank.bffumico.client.ordermarketplace.MarketplaceClient;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.CreateOrderRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.PurchaseRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.RefundRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.TelesalesResultRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.CheckOrderResponse;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.CreateOrderResponse;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.PurchaseResponse;
import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import az.kapitalbank.bffumico.dto.request.PurchaseRequestDto;
import az.kapitalbank.bffumico.dto.request.RefundRequestDto;
import az.kapitalbank.bffumico.dto.request.TelesalesResultRequestDto;
import az.kapitalbank.bffumico.dto.response.CheckOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.CreateOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.PurchaseResponseDto;
import az.kapitalbank.bffumico.mapper.OrderMapper;
import az.kapitalbank.bffumico.mapper.ScoringMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    OrderMapper orderMapper;
    @Mock
    ScoringMapper scoringMapper;
    @Mock
    MarketplaceClient marketplaceClient;
    @InjectMocks
    OrderService orderService;

    @Test
    void createOrder_Success() {

        var createOrderRequestDto = CreateOrderRequestDto.builder().build();
        var createOrderRequest = CreateOrderRequest.builder().build();
        var createOrderResponse = CreateOrderResponse.builder().build();
        var expected = CreateOrderResponseDto.builder().build();

        when(orderMapper.toCreateOrderRequest(createOrderRequestDto)).thenReturn(
                createOrderRequest);
        when(marketplaceClient.create(createOrderRequest)).thenReturn(
                createOrderResponse);
        when(orderMapper.toCreateOrderResponseDto(createOrderResponse)).thenReturn(expected);

        var actual = orderService.create(createOrderRequestDto);
        assertEquals(expected, actual);
    }

    @Test
    void checkOrder_Success() {
        String telesalesOrderId = "aslsdhblcasndfc";
        var checkOrderResponse = CheckOrderResponse.builder().build();
        var expected = CheckOrderResponseDto.builder().build();

        when(marketplaceClient.check(telesalesOrderId)).thenReturn(checkOrderResponse);
        when(orderMapper.toCheckOrderResponseDto(checkOrderResponse)).thenReturn(
                expected);

        var actual = orderService.check(telesalesOrderId);
        assertEquals(expected, actual);
    }

    @Test
    void refundOrder_Success() {
        var refundRequestDto = RefundRequestDto.builder().build();
        var refundRequest = RefundRequest.builder().build();
        var purchaseResponse = PurchaseResponse.builder().build();
        var expected = PurchaseResponseDto.builder().build();

        when(orderMapper.toRefundRequest(refundRequestDto)).thenReturn(refundRequest);
        when(marketplaceClient.refundOrder(refundRequest)).thenReturn(purchaseResponse);

        orderService.refund(refundRequestDto);
        verify(orderMapper).toRefundRequest(refundRequestDto);
    }

    @Test
    void purchase_Success() {
        var purchaseRequestDto = PurchaseRequestDto.builder().build();
        var purchaseRequest = PurchaseRequest.builder().build();

        when(orderMapper.toPurchaseRequest(purchaseRequestDto)).thenReturn(purchaseRequest);

        orderService.purchase(purchaseRequestDto);
        verify(orderMapper).toPurchaseRequest(purchaseRequestDto);
    }

    @Test
    void telesalesResult_Success() {
        var requestDto = TelesalesResultRequestDto.builder().build();
        var request = TelesalesResultRequest.builder().build();
        when(scoringMapper.toScoringOrderRequest(requestDto)).thenReturn(request);

        orderService.telesalesResult(requestDto);

        verify(scoringMapper).toScoringOrderRequest(requestDto);
        verify(marketplaceClient).telesalesResult(request);
    }
}
