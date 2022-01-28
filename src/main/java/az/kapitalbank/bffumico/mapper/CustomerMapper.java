package az.kapitalbank.bffumico.mapper;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.BalanceRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.BalanceResponse;
import az.kapitalbank.bffumico.dto.request.BalanceRequestDto;
import az.kapitalbank.bffumico.dto.response.BalanceResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    BalanceResponseDto toBalanceResponseDto(BalanceResponse balanceResponse);

    BalanceRequest toBalanceRequest(BalanceRequestDto requestDto);
}
