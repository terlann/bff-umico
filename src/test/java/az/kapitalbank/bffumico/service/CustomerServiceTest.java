package az.kapitalbank.bffumico.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import az.kapitalbank.bffumico.client.ordermarketplace.CustomerCardClient;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.BalanceResponse;
import az.kapitalbank.bffumico.dto.response.BalanceResponseDto;
import az.kapitalbank.bffumico.mapper.CustomerMapper;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    CustomerMapper customerMapper;
    @Mock
    CustomerCardClient customerCardClient;
    @InjectMocks
    CustomerService customerService;

    @Test
    void getCustomerBalance_Success() {
        String umicoUserId = "db56142a-a06f-11ec-b909-0242ac120002";
        var customerId = UUID.randomUUID();
        var balanceResponse = BalanceResponse.builder().build();
        var expected = BalanceResponseDto.builder().build();
        when(customerCardClient.getCustomerBalance(umicoUserId, customerId)).thenReturn(
                balanceResponse);
        when(customerMapper.toBalanceResponseDto(balanceResponse)).thenReturn(expected);

        var actual = customerService.getCustomerBalance(umicoUserId, customerId);
        assertEquals(expected, actual);
    }

    @Test
    void checkPin_Success() {
        String pin = "AA1BB2";
        customerService.checkPin(pin);
        verify(customerCardClient).checkPin(pin);
    }
}
