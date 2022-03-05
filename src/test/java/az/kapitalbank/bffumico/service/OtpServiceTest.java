package az.kapitalbank.bffumico.service;

import java.util.UUID;

import az.kapitalbank.bffumico.client.ordermarketplace.OrderMarketplaceClient;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.SendOtpRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.SendOtpResponse;
import az.kapitalbank.bffumico.dto.request.SendOtpRequestDto;
import az.kapitalbank.bffumico.dto.response.SendOtpResponseDto;
import az.kapitalbank.bffumico.mapper.OtpMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.LenientCopyTool;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
                .message("success")
                .maskedMobileNum("*********7040")
                .build();
        var sendOtpResponseDto = SendOtpResponseDto.builder()
                .message("success")
                .maskedMobileNum("*********7040")
                .build();

        when(otpMapper.toSendOtpRequest(sendOtpRequestDto)).thenReturn(sendOtpRequest);
        when(orderMarketplaceClient.send(sendOtpRequest)).thenReturn(sendOtpResponse);
        when(otpMapper.toSendOtpResponseDto(sendOtpResponse)).thenReturn(sendOtpResponseDto);

        otpService.send(sendOtpRequestDto);

        verify(otpMapper).toSendOtpRequest(sendOtpRequestDto);
        verify(otpMapper).toSendOtpResponseDto(sendOtpResponse);
        verify(orderMarketplaceClient).send(sendOtpRequest);
    }

}