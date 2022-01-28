package az.kapitalbank.bffumico.mapper;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.CreateOrderRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.PurchaseRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.ReverseRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.CheckOrderResponse;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.CreateOrderResponse;
import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import az.kapitalbank.bffumico.dto.request.PurchaseRequestDto;
import az.kapitalbank.bffumico.dto.request.ReverseRequestDto;
import az.kapitalbank.bffumico.dto.response.CheckOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.CreateOrderResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    CreateOrderRequest toCreateOrderRequest(CreateOrderRequestDto createOrderRequestDto);

    CreateOrderResponseDto toCreateOrderResponseDto(CreateOrderResponse body);

    CheckOrderResponseDto toCheckOrderResponseDto(CheckOrderResponse checkOrderResponse);

    ReverseRequest toReverseRequest(ReverseRequestDto request);

    PurchaseRequest toPurchaseRequest(PurchaseRequestDto request);
}
