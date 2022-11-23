package az.kapitalbank.bffumico.controller;

import static az.kapitalbank.bffumico.constants.TestConstants.CUSTOMER_ID;
import static az.kapitalbank.bffumico.constants.TestConstants.PIN;
import static az.kapitalbank.bffumico.constants.TestConstants.UMICO_USER_ID;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import az.kapitalbank.bffumico.dto.response.BalanceResponseDto;
import az.kapitalbank.bffumico.service.CustomerService;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("local")
@WebMvcTest(CustomerController.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    static final String BASE_URL = "/api/v1/customers";

    @Test
    void getCustomerBalance_ShouldReturnStatusOk() throws Exception {
        var response = BalanceResponseDto.builder().availableBalance(BigDecimal.ONE).build();

        when(customerService.getCustomerBalance(UMICO_USER_ID.getValue(),
                UUID.fromString(CUSTOMER_ID.getValue()))).thenReturn(response);

        mockMvc.perform(get(BASE_URL + "/balance")
                        .param("umico_user_id", UMICO_USER_ID.getValue())
                        .param("customer_id", CUSTOMER_ID.getValue()))
                .andExpect(jsonPath("$.available_balance").value(response.getAvailableBalance()))
                .andExpect(status().isOk());

        verify(customerService).getCustomerBalance(UMICO_USER_ID.getValue(),
                UUID.fromString(CUSTOMER_ID.getValue()));
    }

    @Test
    void checkPin_ShouldReturnStatusNoContent() throws Exception {
        mockMvc.perform(get(BASE_URL + "/check/1234567"))
                .andExpect(status().isNoContent());

        verify(customerService).checkPin(PIN.getValue());
    }
}
