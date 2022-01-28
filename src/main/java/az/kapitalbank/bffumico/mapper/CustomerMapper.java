package az.kapitalbank.bffumico.mapper;

import az.kapitalbank.bffumico.client.ordermarketplace.model.response.BalanceResponse;
import az.kapitalbank.bffumico.dto.response.BalanceResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    BalanceResponseDto toBalanceResponseDto(BalanceResponse balanceResponse);

}
