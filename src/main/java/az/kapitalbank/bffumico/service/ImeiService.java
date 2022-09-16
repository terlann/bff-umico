package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.MarketplaceClient;
import az.kapitalbank.bffumico.dto.request.ImeiCodeRequestDto;
import az.kapitalbank.bffumico.mapper.ImeiMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ImeiService {

    MarketplaceClient marketplaceClient;
    ImeiMapper imeiMapper;

    public void saveImei(ImeiCodeRequestDto imeiCodeRequestDto) {
        log.info("Save imei code started. orderNo - {}", imeiCodeRequestDto.getOrderNo());
        marketplaceClient.saveImeiCode(imeiMapper.toImeiCodeRequest(imeiCodeRequestDto));
    }
}
