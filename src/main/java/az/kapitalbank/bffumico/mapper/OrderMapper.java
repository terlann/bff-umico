package az.kapitalbank.bffumico.mapper;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.CreateOrderRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.ReverseRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.CheckOrderResponse;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.CreateOrderResponse;
import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import az.kapitalbank.bffumico.dto.request.ReverseRequestDto;
import az.kapitalbank.bffumico.dto.response.CheckOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.CreateOrderResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    //    @Mapping(source = "fullname", target = "customerInfo.fullname")
//    @Mapping(source = "phoneNumber", target = "customerInfo.phoneNumber")
//    @Mapping(source = "pincode", target = "customerInfo.pincode")
//    @Mapping(source = "email", target = "customerInfo.email")
//    @Mapping(source = "isAgreement", target = "customerInfo.isAgreement")
//    @Mapping(source = "workPlace", target = "customerInfo.workPlace")
//    @Mapping(source = "additionalPhoneNumber1", target = "customerInfo.additionalPhoneNumber1")
//    @Mapping(source = "additionalPhoneNumber2", target = "customerInfo.additionalPhoneNumber2")
//    @Mapping(source = "umicoUserId", target = "customerDetail.umicoUserId")
//    @Mapping(source = "userIp", target = "customerDetail.userIp")
//    @Mapping(source = "umicoRegistrationPhone", target = "customerDetail.umicoRegistrationPhone")
//    @Mapping(source = "userAgent", target = "customerDetail.userAgent")
//    @Mapping(source = "originationLat", target = "customerDetail.originationLat")
//    @Mapping(source = "originationLan", target = "customerDetail.originationLan")
//    @Mapping(source = "umicoRegistrationDate", target = "customerDetail.umicoRegistrationDate")
    CreateOrderRequest toCreateOrderRequest(CreateOrderRequestDto createOrderRequestDto);

    @Mapping(target = "trackId", source = "marketplaceTrackId")
    CreateOrderResponseDto toCreateOrderResponseDto(CreateOrderResponse body);

    CheckOrderResponseDto toCheckOrderResponseDto(CheckOrderResponse checkOrderResponse);

    ReverseRequest toReverseRequest(ReverseRequestDto request);

}
