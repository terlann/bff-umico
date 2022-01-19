package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.CustomerCardClient;
import az.kapitalbank.bffumico.dto.response.WrapperResponseDto;
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

    public WrapperResponseDto<Object> getCustomerBalance(String customerId) {
        var balanceResponse = customerCardClient.getCustomerBalance(customerId);
        var wrapper = WrapperResponseDto.ofSuccess();
        wrapper.setData(customerMapper.toBalanceResponseDto(balanceResponse.getData()));
        return wrapper;
    }

}
