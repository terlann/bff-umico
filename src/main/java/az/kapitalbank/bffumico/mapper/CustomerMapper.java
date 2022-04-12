package az.kapitalbank.bffumico.mapper;

import az.kapitalbank.bffumico.client.ordermarketplace.model.response.BalanceResponse;
import az.kapitalbank.bffumico.dto.response.BalanceResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "loanEndDate", source = "cardExpiryDate")
    BalanceResponseDto toBalanceResponseDto(BalanceResponse balanceResponse);

}
