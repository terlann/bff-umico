package az.kapitalbank.bffumico.mapper;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.OtpVerifyRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.SendOtpRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.SendOtpResponse;
import az.kapitalbank.bffumico.dto.request.OtpVerifyRequestDto;
import az.kapitalbank.bffumico.dto.request.SendOtpRequestDto;
import az.kapitalbank.bffumico.dto.response.SendOtpResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OtpMapper {

    SendOtpRequest toSendOtpRequest(SendOtpRequestDto request);

    SendOtpResponseDto toSendOtpResponseDto(SendOtpResponse response);

    OtpVerifyRequest toOtpVerifyRequest(OtpVerifyRequestDto request);

}
