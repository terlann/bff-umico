package az.kapitalbank.bffumico.controller;

import static az.kapitalbank.bffumico.constants.TestConstants.MOBILE_NUMBER;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import az.kapitalbank.bffumico.dto.request.SendOtpRequestDto;
import az.kapitalbank.bffumico.dto.request.VerifyOtpRequestDto;
import az.kapitalbank.bffumico.dto.response.SendOtpResponseDto;
import az.kapitalbank.bffumico.service.OtpService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@WebMvcTest(OtpController.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
class OtpControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    OtpService otpService;

    static final String BASE_URL = "/api/v1/otp";

    @Test
    void send_ShouldReturnStatusOk() throws Exception {
        var request = SendOtpRequestDto.builder().build();
        var response = SendOtpResponseDto.builder()
                .maskedMobileNumber(MOBILE_NUMBER.getValue()).build();

        when(otpService.send(request)).thenReturn(response);

        mockMvc.perform(post(BASE_URL + "/send")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(jsonPath("$.masked_mobile_number")
                        .value(response.getMaskedMobileNumber()))
                .andExpect(status().isOk());

        verify(otpService).send(request);
    }

    @Test
    void verify_ShouldReturnStatusNoContent() throws Exception {
        var request = VerifyOtpRequestDto.builder().build();

        mockMvc.perform(post(BASE_URL + "/verify")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNoContent());

        verify(otpService).verify(request);
    }
}
