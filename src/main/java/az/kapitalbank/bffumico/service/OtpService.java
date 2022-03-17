package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.OrderMarketplaceClient;
import az.kapitalbank.bffumico.dto.request.SendOtpRequestDto;
import az.kapitalbank.bffumico.dto.request.VerifyOtpRequestDto;
import az.kapitalbank.bffumico.dto.response.SendOtpResponseDto;
import az.kapitalbank.bffumico.mapper.OtpMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OtpService {
    private final OrderMarketplaceClient orderMarketplaceClient;
    private final OtpMapper otpMapper;

    public SendOtpResponseDto send(SendOtpRequestDto requestDto) {
        var sendOtpRequest = otpMapper.toSendOtpRequest(requestDto);
        var sendOtpResponse = orderMarketplaceClient.send(sendOtpRequest);
        return otpMapper.toSendOtpResponseDto(sendOtpResponse);
    }

    public void verify(VerifyOtpRequestDto requestDto) {
        var otpVerifyRequest = otpMapper.toOtpVerifyRequest(requestDto);
        orderMarketplaceClient.verify(otpVerifyRequest);
    }
}
