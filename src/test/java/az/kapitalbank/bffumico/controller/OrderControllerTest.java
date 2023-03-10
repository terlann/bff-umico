package az.kapitalbank.bffumico.controller;

import static az.kapitalbank.bffumico.constants.TestConstants.TELESALES_ORDER_ID;
import static az.kapitalbank.bffumico.constants.TestConstants.TRACK_ID;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import az.kapitalbank.bffumico.dto.request.PurchaseRequestDto;
import az.kapitalbank.bffumico.dto.request.RefundRequestDto;
import az.kapitalbank.bffumico.dto.request.TelesalesResultRequestDto;
import az.kapitalbank.bffumico.dto.response.CheckOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.CreateOrderResponseDto;
import az.kapitalbank.bffumico.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("local")
@WebMvcTest(OrderController.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    OrderService orderService;

    public static final String BASE_URL = "/api/v1/orders";

    @Test
    void createOrder_ShouldReturnStatusCreated() throws Exception {
        var request = CreateOrderRequestDto.builder().build();
        var response = CreateOrderResponseDto.builder()
                .trackId(UUID.fromString(TRACK_ID.getValue()))
                .build();

        when(orderService.create(request)).thenReturn(response);

        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(jsonPath("$.track_id", is(response.getTrackId().toString())))
                .andExpect(status().isCreated());

        verify(orderService).create(request);
    }

    @Test
    void refund_ShouldReturnStatusNoContent() throws Exception {
        var request = RefundRequestDto.builder().build();

        mockMvc.perform(post(BASE_URL + "/refund")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNoContent());

        verify(orderService).refund(request);
    }

    @Test
    void checkOrder_ShouldReturnStatusOk() throws Exception {
        var response = CheckOrderResponseDto.builder()
                .telesalesOrderId(TELESALES_ORDER_ID.getValue()).build();

        when(orderService.check(TELESALES_ORDER_ID.getValue())).thenReturn(response);

        mockMvc.perform(post(BASE_URL + "/check/" + TELESALES_ORDER_ID.getValue()))
                .andExpect(jsonPath("$.telesalesOrderId", is(response.getTelesalesOrderId())))
                .andExpect(status().isOk());

        verify(orderService).check(TELESALES_ORDER_ID.getValue());
    }

    @Test
    void purchase_ShouldReturnStatusNoContent() throws Exception {
        var request = PurchaseRequestDto.builder().build();

        mockMvc.perform(post(BASE_URL + "/purchase")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNoContent());

        verify(orderService).purchase(request);
    }

    @Test
    void telesalesResult_ShouldReturnStatusNoContent() throws Exception {
        var request = TelesalesResultRequestDto.builder().build();

        mockMvc.perform(post(BASE_URL + "/telesales/result")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNoContent());
        verify(orderService).telesalesResult(request);
    }
}
