package az.kapitalbank.bffumico.service;

import java.util.UUID;

import az.kapitalbank.bffumico.client.ordermarketplace.CustomerCardClient;
import az.kapitalbank.bffumico.dto.response.BalanceResponseDto;
import az.kapitalbank.bffumico.mapper.CustomerMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerService {

    CustomerMapper customerMapper;
    CustomerCardClient customerCardClient;

    public BalanceResponseDto getCustomerBalance(String umicoUserId, UUID customerId) {
        var balanceResponse = customerCardClient.getCustomerBalance(umicoUserId, customerId);
        return customerMapper.toBalanceResponseDto(balanceResponse);
    }

    public void checkPin(String pin) {
        customerCardClient.checkPin(pin);
    }

}
