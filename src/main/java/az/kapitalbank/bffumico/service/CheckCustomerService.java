package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.order_marketplace.OrderMarketplaceClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CheckCustomerService {


    final OrderMarketplaceClient orderMarketplaceClient;

    public ResponseEntity<?> checkPinCode(String pinCode) {
        return ResponseEntity.ok(orderMarketplaceClient.checkPinCode(pinCode));
    }
}
