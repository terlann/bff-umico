package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.CustomerClient;
import az.kapitalbank.bffumico.dto.response.BalanceResponseDto;
import az.kapitalbank.bffumico.mapper.CustomerMapper;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerService {

    CustomerMapper customerMapper;
    CustomerClient customerClient;

    public BalanceResponseDto getCustomerBalance(String umicoUserId, UUID customerId) {
        log.info("get customer balance service started. umicoUserId: {}, customerId: {}",
                umicoUserId, customerId);
        var balanceResponse = customerClient.getCustomerBalance(umicoUserId, customerId);
        log.info("get customer balance service ended. balanceResponse: {}", balanceResponse);
        return customerMapper.toBalanceResponseDto(balanceResponse);
    }

    public void checkPin(String pin) {
        log.info("customer check pin service started. pin: {}", pin);
        customerClient.checkPin(pin);
        log.info("customer check pin service ended. pin: {}", pin);
    }

}
