package az.kapitalbank.bffumico.mapper;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.TelesalesResultRequest;
import az.kapitalbank.bffumico.dto.request.TelesalesRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScoringMapper {

    TelesalesResultRequest toScoringOrderRequest(TelesalesRequestDto request);

}
