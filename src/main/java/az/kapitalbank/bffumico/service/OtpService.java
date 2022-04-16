package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.MarketplaceClient;
import az.kapitalbank.bffumico.dto.request.SendOtpRequestDto;
import az.kapitalbank.bffumico.dto.request.VerifyOtpRequestDto;
import az.kapitalbank.bffumico.dto.response.SendOtpResponseDto;
import az.kapitalbank.bffumico.mapper.OtpMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class OtpService {

    MarketplaceClient marketplaceClient;
    OtpMapper otpMapper;

    public SendOtpResponseDto send(SendOtpRequestDto request) {
        log.info("send otp service started. request: {}", request);
        var response = marketplaceClient.send(otpMapper.toSendOtpRequest(request));
        log.info("send otp service ended. response: {}", response);
        return otpMapper.toSendOtpResponseDto(response);
    }

    public void verify(VerifyOtpRequestDto request) {
        log.info("verify otp service started. request: {}", request);
        marketplaceClient.verify(otpMapper.toOtpVerifyRequest(request));
        log.info("verify otp service ended. request: {}", request);
    }
}
