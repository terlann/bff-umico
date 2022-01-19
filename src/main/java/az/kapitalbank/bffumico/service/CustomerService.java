package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.CustomerCardClient;
import az.kapitalbank.bffumico.dto.response.BalanceResponseDto;
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

    public BalanceResponseDto getCustomerBalance(String customerId) {
        var balanceResponse = customerCardClient.getCustomerBalance(customerId);
        return customerMapper.toBalanceResponseDto(balanceResponse);
    }

}
