package az.kapitalbank.bffumico.mapper;

import az.kapitalbank.bffumico.client.ordermarketplace.model.CreateOrderRequest;
import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateOrderMapper {

    @Mapping(source = "fullname",target = "customerInfo.fullname")
    @Mapping(source = "phoneNumber",target = "customerInfo.phoneNumber")
    @Mapping(source = "pincode",target = "customerInfo.pincode")
    @Mapping(source = "email",target = "customerInfo.email")
    @Mapping(source = "isAgreement",target = "customerInfo.isAgreement")
    @Mapping(source = "workPlace",target = "customerInfo.workPlace")
    @Mapping(source = "additionalPhoneNumber1",target = "customerInfo.additionalPhoneNumber1")
    @Mapping(source = "additionalPhoneNumber2",target = "customerInfo.additionalPhoneNumber2")
    @Mapping(source = "umicoUserId",target = "customerInfo.umicoUserId")
    @Mapping(source = "userIp",target = "customerInfo.userIp")
    @Mapping(source = "umicoRegistrationPhone",target = "customerInfo.umicoRegistrationPhone")
    @Mapping(source = "userAgent",target = "customerInfo.userAgent")
    @Mapping(source = "originationLat",target = "customerInfo.originationLat")
    @Mapping(source = "originationLan",target = "customerInfo.originationLan")
    @Mapping(source = "umicoRegistrationDate",target = "customerInfo.umicoRegistrationDate")
    CreateOrderRequest toCreateOrderRequest(CreateOrderRequestDto createOrderRequestDto);
}
