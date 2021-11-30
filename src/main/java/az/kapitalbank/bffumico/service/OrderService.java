package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.order_marketplace.OrderMarketplaceClient;
import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
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

    public ResponseEntity<?> createOrder(CreateOrderRequestDto request) {
        return ResponseEntity.ok(orderMarketplaceClient.createOrder(request));
    }

    public ResponseEntity<?> deleteOrder(String trackId) {
        return ResponseEntity.ok(orderMarketplaceClient.deleteOrder(trackId));
    }

}