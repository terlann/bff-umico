package az.kapitalbank.bffumico.service;

import az.kapitalbank.bffumico.client.ordermarketplace.OrderMarketplaceClient;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.TelesalesResultRequest;
import az.kapitalbank.bffumico.dto.request.TelesalesResultRequestDto;
import az.kapitalbank.bffumico.mapper.OrderMapper;
import az.kapitalbank.bffumico.mapper.ScoringMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    @Mock
    OrderMapper orderMapper;
    @Mock
    ScoringMapper scoringMapper;
    @Mock
    OrderMarketplaceClient orderMarketplaceClient;
    @InjectMocks
    OrderService orderService;

    @Test
    void telesalesResult() {
        var requestDto = TelesalesResultRequestDto.builder()
                .pan("123456789")
                .build();
        var request = TelesalesResultRequest.builder()
                .pan("123456789")
                .build();
        when(scoringMapper.toScoringOrderRequest(requestDto)).thenReturn(request);

        orderService.telesalesResult(requestDto);

        verify(scoringMapper).toScoringOrderRequest(requestDto);
        verify(orderMarketplaceClient).telesalesResult(request);
    }
}
