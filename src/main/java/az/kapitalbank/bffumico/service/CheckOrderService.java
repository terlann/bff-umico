package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.order_marketplace.OrderMarketplaceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckOrderService {

    OrderMarketplaceClient orderMarketplaceClient;

    public ResponseEntity<?> checkOrder(String eteId) {
        return ResponseEntity.ok(orderMarketplaceClient.checkOrder(eteId));
    }

}
