package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.OrderMarketplaceClient;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.ScoringOrderRequest;
import az.kapitalbank.bffumico.dto.request.ScoringOrderRequestDto;
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

    public void telesalesResult(ScoringOrderRequestDto request) {
        ScoringOrderRequest orderRequest = scoringMapper.toScoringOrderRequest(request);
        orderMarketplaceClient.telesalesResult(orderRequest);
    }
}
