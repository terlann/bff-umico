package az.kapitalbank.bffumico.mapper;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.ImeiCodeRequest;
import az.kapitalbank.bffumico.dto.request.ImeiCodeRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImeiMapper {
    ImeiCodeRequest toImeiCodeRequest(ImeiCodeRequestDto imeiCodeRequestDto);
}
