package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.OrderMarketplaceClient;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.TelesalesResultRequest;
import az.kapitalbank.bffumico.dto.request.TelesalesRequestDto;
import az.kapitalbank.bffumico.mapper.ScoringMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ScoringService {

    ScoringMapper scoringMapper;
    OrderMarketplaceClient orderMarketplaceClient;

    public void telesalesResult(TelesalesRequestDto request) {
        TelesalesResultRequest orderRequest = scoringMapper.toScoringOrderRequest(request);
        orderMarketplaceClient.telesalesResult(orderRequest);
    }
}
