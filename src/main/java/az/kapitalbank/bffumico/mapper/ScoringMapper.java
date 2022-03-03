package az.kapitalbank.bffumico.mapper;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.ScoringOrderRequest;
import az.kapitalbank.bffumico.dto.request.ScoringOrderRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScoringMapper {

    ScoringOrderRequest toScoringOrderRequest(ScoringOrderRequestDto request);

}
