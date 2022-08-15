package az.kapitalbank.bffumico.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import az.kapitalbank.bffumico.client.ordermarketplace.MarketplaceClient;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.DvsResult;
import az.kapitalbank.bffumico.dto.request.DvsResultDto;
import az.kapitalbank.bffumico.mapper.DvsMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DvsServiceTest {

    @Mock
    DvsMapper dvsMapper;
    @Mock
    MarketplaceClient marketplaceClient;
    @InjectMocks
    DvsService dvsService;

    @Test
    void verificationResultProcess_Success() {
        DvsResultDto dvsResultDto = DvsResultDto.builder()
                .personOrderId("1234")
                .build();
        DvsResult dvsResult = DvsResult.builder()
                .personOrderId("1234")
                .build();
        when(dvsMapper.toDvsResult(dvsResultDto)).thenReturn(dvsResult);
        dvsService.verificationResultProcess(dvsResultDto);
        verify(dvsMapper).toDvsResult(dvsResultDto);
    }
}
