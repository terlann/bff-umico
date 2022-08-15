package az.kapitalbank.bffumico.mapper;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.DvsResult;
import az.kapitalbank.bffumico.dto.request.DvsResultDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DvsMapper {
    DvsResult toDvsResult(DvsResultDto dvsResultDto);
}
