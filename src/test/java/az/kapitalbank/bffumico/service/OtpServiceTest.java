package az.kapitalbank.bffumico.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import az.kapitalbank.bffumico.client.ordermarketplace.OrderMarketplaceClient;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.OtpVerifyRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.SendOtpRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.SendOtpResponse;
import az.kapitalbank.bffumico.dto.request.OtpVerifyRequestDto;
import az.kapitalbank.bffumico.dto.request.SendOtpRequestDto;
import az.kapitalbank.bffumico.dto.response.SendOtpResponseDto;
import az.kapitalbank.bffumico.mapper.OtpMapper;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OtpServiceTest {

    @Mock
    OrderMarketplaceClient orderMarketplaceClient;

    @Mock
    OtpMapper otpMapper;

    @InjectMocks
    OtpService otpService;

    @Test
    void send() {
        var sendOtpRequest = SendOtpRequest.builder()
                .trackId(UUID.fromString("3a30a65a-9bec-11ec-b909-0242ac120002"))
                .build();
        var sendOtpRequestDto = SendOtpRequestDto.builder()
                .trackId(UUID.fromString("3a30a65a-9bec-11ec-b909-0242ac120002"))
                .build();
        var sendOtpResponse = SendOtpResponse.builder()
                .maskedMobileNumber("*********7040")
                .build();
        var sendOtpResponseDto = SendOtpResponseDto.builder()
                .maskedMobileNumber("*********7040")
                .build();

        when(otpMapper.toSendOtpRequest(sendOtpRequestDto)).thenReturn(sendOtpRequest);
        when(orderMarketplaceClient.send(sendOtpRequest)).thenReturn(sendOtpResponse);
        when(otpMapper.toSendOtpResponseDto(sendOtpResponse)).thenReturn(sendOtpResponseDto);

        otpService.send(sendOtpRequestDto);

        verify(otpMapper).toSendOtpRequest(sendOtpRequestDto);
        verify(otpMapper).toSendOtpResponseDto(sendOtpResponse);
        verify(orderMarketplaceClient).send(sendOtpRequest);
    }

    @Test
    void verify_success() {
        var otpVerifyRequest = OtpVerifyRequest.builder().otp("1234")
                .trackId(UUID.fromString("3a30a65a-9bec-11ec-b909-0242ac120002")).build();
        var otpVerifyRequestDto = OtpVerifyRequestDto.builder().otp("1234")
                .trackId(UUID.fromString("3a30a65a-9bec-11ec-b909-0242ac120002")).build();
        when(otpMapper.toOtpVerifyRequest(otpVerifyRequestDto)).thenReturn(otpVerifyRequest);


        otpService.verify(otpVerifyRequestDto);

        verify(otpMapper).toOtpVerifyRequest(otpVerifyRequestDto);
        verify(orderMarketplaceClient).verify(otpVerifyRequest);
    }
}
