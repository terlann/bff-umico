package az.kapitalbank.bffumico.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.SendOtpRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.VerifyOtpRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.SendOtpResponse;
import az.kapitalbank.bffumico.dto.request.SendOtpRequestDto;
import az.kapitalbank.bffumico.dto.request.VerifyOtpRequestDto;
import az.kapitalbank.bffumico.dto.response.SendOtpResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@SpringBootTest(classes = OtpMapperImpl.class)
class OtpMapperTest {

    @Autowired
    OtpMapper otpMapper;

    @Test
    void toSendOtpRequest() {
        var telesalesResultRequestDto = SendOtpRequestDto.builder().build();
        var expected = SendOtpRequest.builder().build();

        var actual = otpMapper.toSendOtpRequest(telesalesResultRequestDto);

        assertEquals(expected, actual);
    }

    @Test
    void toSendOtpResponseDto() {
        var sendOtpResponse = SendOtpResponse.builder().build();
        var expected = SendOtpResponseDto.builder().build();

        var actual = otpMapper.toSendOtpResponseDto(sendOtpResponse);

        assertEquals(expected, actual);
    }

    @Test
    void toOtpVerifyRequest() {
        var verifyOtpRequestDto = VerifyOtpRequestDto.builder().build();
        var expected = VerifyOtpRequest.builder().build();

        var actual = otpMapper.toOtpVerifyRequest(verifyOtpRequestDto);

        assertEquals(expected, actual);
    }
}
