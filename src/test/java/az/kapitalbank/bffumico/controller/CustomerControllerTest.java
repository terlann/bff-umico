package az.kapitalbank.bffumico.controller;

import static az.kapitalbank.bffumico.constants.TestConstants.CUSTOMER_ID;
import static az.kapitalbank.bffumico.constants.TestConstants.PIN;
import static az.kapitalbank.bffumico.constants.TestConstants.UMICO_USER_ID;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import az.kapitalbank.bffumico.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("local")
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    CustomerService customerService;

    @Test
    void getCustomerBalance() throws Exception {
        mockMvc.perform(get("/api/v1/customers/balance")
                        .param("umico_user_id", UMICO_USER_ID.getValue())
                        .param("customer_id", CUSTOMER_ID.getValue()))
                .andExpect(status().isOk());

        verify(customerService).getCustomerBalance(UMICO_USER_ID.getValue(),
                UUID.fromString(CUSTOMER_ID.getValue()));
    }

    @Test
    void checkPin() throws Exception {
        mockMvc.perform(get("/api/v1/customers/check/1234567"))
                .andExpect(status().isNoContent());

        verify(customerService).checkPin(PIN.getValue());
    }
}
