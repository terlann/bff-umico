package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.model.BalanceResponse;
import az.kapitalbank.bffumico.dto.response.BalanceResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    BalanceResponseDto toBalanceResponseDto(BalanceResponse balanceResponse);

}
