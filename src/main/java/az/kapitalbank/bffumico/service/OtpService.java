package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.OrderMarketplaceClient;
import az.kapitalbank.bffumico.dto.request.SendOtpRequestDto;
import az.kapitalbank.bffumico.dto.response.SendOtpResponseDto;
import az.kapitalbank.bffumico.mapper.OtpMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OtpService {
    OrderMarketplaceClient orderMarketplaceClient;
    OtpMapper otpMapper;

    public SendOtpResponseDto send(SendOtpRequestDto requestDto) {
        var sendOtpRequest = otpMapper.toSendOtpRequest(requestDto);
        var sendOtpResponse = orderMarketplaceClient.send(sendOtpRequest);
        return otpMapper.toSendOtpResponseDto(sendOtpResponse);
    }
}
