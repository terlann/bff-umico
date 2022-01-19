package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.OrderMarketplaceClient;
import az.kapitalbank.bffumico.client.ordermarketplace.model.CreateOrderRequest;
import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import az.kapitalbank.bffumico.dto.response.WrapperResponseDto;
import az.kapitalbank.bffumico.mapper.CreateOrderMapper;
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

    OrderMarketplaceClient orderMarketplaceClient;
    CreateOrderMapper createOrderMapper;

    public WrapperResponseDto<Object> createOrder(CreateOrderRequestDto request) {
        CreateOrderRequest createOrderRequest = createOrderMapper.toCreateOrderRequest(request);
        return orderMarketplaceClient.createOrder(createOrderRequest);
    }

    public WrapperResponseDto<Object> deleteOrder(String trackId) {
        return orderMarketplaceClient.deleteOrder(trackId);
    }
}