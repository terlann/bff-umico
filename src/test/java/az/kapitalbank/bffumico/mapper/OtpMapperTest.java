package az.kapitalbank.bffumico.mapper;

import static az.kapitalbank.bffumico.constants.TestConstants.MOBILE_NUMBER;
import static az.kapitalbank.bffumico.constants.TestConstants.OTP;
import static az.kapitalbank.bffumico.constants.TestConstants.TRACK_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.SendOtpRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.VerifyOtpRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.SendOtpResponse;
import az.kapitalbank.bffumico.dto.request.SendOtpRequestDto;
import az.kapitalbank.bffumico.dto.request.VerifyOtpRequestDto;
import az.kapitalbank.bffumico.dto.response.SendOtpResponseDto;
import java.util.UUID;
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
        var telesalesResultRequestDto =
                SendOtpRequestDto.builder().trackId(UUID.fromString(TRACK_ID.getValue())).build();
        var expected =
                SendOtpRequest.builder().trackId(UUID.fromString(TRACK_ID.getValue())).build();

        var actual = otpMapper.toSendOtpRequest(telesalesResultRequestDto);

        assertEquals(expected, actual);
    }

    @Test
    void toSendOtpResponseDto() {
        var sendOtpResponse =
                SendOtpResponse.builder().maskedMobileNumber(MOBILE_NUMBER.getValue()).build();
        var expected =
                SendOtpResponseDto.builder().maskedMobileNumber(MOBILE_NUMBER.getValue()).build();

        var actual = otpMapper.toSendOtpResponseDto(sendOtpResponse);

        assertEquals(expected, actual);
    }

    @Test
    void toOtpVerifyRequest() {
        var verifyOtpRequestDto = VerifyOtpRequestDto.builder().otp(OTP.getValue())
                .trackId(UUID.fromString(TRACK_ID.getValue())).build();
        var expected = VerifyOtpRequest.builder().otp(OTP.getValue())
                .trackId(UUID.fromString(TRACK_ID.getValue())).build();

        var actual = otpMapper.toOtpVerifyRequest(verifyOtpRequestDto);

        assertEquals(expected, actual);
    }
}
