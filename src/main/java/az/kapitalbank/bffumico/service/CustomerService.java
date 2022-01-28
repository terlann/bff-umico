package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.CustomerCardClient;
import az.kapitalbank.bffumico.client.ordermarketplace.OrderMarketplaceClient;
import az.kapitalbank.bffumico.dto.response.BalanceResponseDto;
import az.kapitalbank.bffumico.mapper.CustomerMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerService {

    CustomerMapper customerMapper;
    CustomerCardClient customerCardClient;
    OrderMarketplaceClient orderMarketplaceClient;

    public ResponseEntity<BalanceResponseDto> getCustomerBalance(String umicoUserId, String customerId) {
        var balanceResponse = customerCardClient.getCustomerBalance(umicoUserId, customerId);
        var balanceResponseDto = customerMapper.toBalanceResponseDto(balanceResponse);
        return ResponseEntity.ok(balanceResponseDto);
    }

    public ResponseEntity<Void> checkPinCode(String pin) {
        return customerCardClient.checkPin(pin);
    }


}
