package az.kapitalbank.bffumico.mapper;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.ScoringOrderRequest;
import az.kapitalbank.bffumico.dto.request.ScoringOrderRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScoringMapper {

    @Mapping(target = "loanStartDate", source = "loanContractStartDate")
    @Mapping(target = "loanEndDate", source = "loanContractEndDate")
    @Mapping(target = "pan", source = "cardPan")
    ScoringOrderRequest toScoringOrderRequest(ScoringOrderRequestDto request);

}
