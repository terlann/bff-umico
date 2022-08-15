package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.MarketplaceClient;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.DvsResult;
import az.kapitalbank.bffumico.dto.request.DvsResultDto;
import az.kapitalbank.bffumico.mapper.DvsMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DvsService {

    DvsMapper dvsMapper;
    MarketplaceClient marketplaceClient;

    public void verificationResultProcess(DvsResultDto dvsResultDto) {
        log.info("verification result process started. request: {}", dvsResultDto);
        DvsResult dvsResult = dvsMapper.toDvsResult(dvsResultDto);
        marketplaceClient.verificationResult(dvsResult);
    }
}
