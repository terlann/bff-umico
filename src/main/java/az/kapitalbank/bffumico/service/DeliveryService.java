package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.order_marketplace.OrderMarketplaceClient;
import az.kapitalbank.bffumico.dto.request.DeliveryProductRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeliveryService {

    OrderMarketplaceClient orderMarketplaceClient;

    public ResponseEntity<?> deliveryProducts(DeliveryProductRequestDto request) {
        return ResponseEntity.ok(orderMarketplaceClient.deliveryProducts(request));
    }


}