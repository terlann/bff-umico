package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.OrderMarketplaceClient;
import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import az.kapitalbank.bffumico.dto.response.WrapperResponseDto;
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

    public WrapperResponseDto<?> createOrder(CreateOrderRequestDto request) {
        return orderMarketplaceClient.createOrder(request);
    }

    public WrapperResponseDto<?> deleteOrder(String trackId) {
        return orderMarketplaceClient.deleteOrder(trackId);
    }
}