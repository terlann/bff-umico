package az.kapitalbank.bffumico.mapper;

import az.kapitalbank.bffumico.client.ordermarketplace.model.CreateOrderRequest;
import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateOrderMapper {

    @Mapping(source = "fullname", target = "customerInfo.fullname")
    @Mapping(source = "phoneNumber", target = "customerInfo.phoneNumber")
    @Mapping(source = "pincode", target = "customerInfo.pincode")
    @Mapping(source = "email", target = "customerInfo.email")
    @Mapping(source = "isAgreement", target = "customerInfo.isAgreement")
    @Mapping(source = "workPlace", target = "customerInfo.workPlace")
    @Mapping(source = "additionalPhoneNumber1", target = "customerInfo.additionalPhoneNumber1")
    @Mapping(source = "additionalPhoneNumber2", target = "customerInfo.additionalPhoneNumber2")
    @Mapping(source = "umicoUserId", target = "customerDetail.umicoUserId")
    @Mapping(source = "userIp", target = "customerDetail.userIp")
    @Mapping(source = "umicoRegistrationPhone", target = "customerDetail.umicoRegistrationPhone")
    @Mapping(source = "userAgent", target = "customerDetail.userAgent")
    @Mapping(source = "originationLat", target = "customerDetail.originationLat")
    @Mapping(source = "originationLan", target = "customerDetail.originationLan")
    @Mapping(source = "umicoRegistrationDate", target = "customerDetail.umicoRegistrationDate")
    CreateOrderRequest toCreateOrderRequest(CreateOrderRequestDto createOrderRequestDto);
}
