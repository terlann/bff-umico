package az.kapitalbank.bffumico.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import az.kapitalbank.bffumico.client.ordermarketplace.MarketplaceClient;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.ImeiCodeRequest;
import az.kapitalbank.bffumico.dto.request.ImeiCodeRequestDto;
import az.kapitalbank.bffumico.mapper.ImeiMapper;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ImeiServiceTest {

    @Mock
    MarketplaceClient marketplaceClient;
    @Mock
    ImeiMapper imeiMapper;
    @InjectMocks
    ImeiService imeiService;

    @Test
    void saveImei() {
        var imeiCodeRequest = ImeiCodeRequest.builder()
                .imeiCodes(Set.of("TT11"))
                .orderNo("3123456789")
                .build();
        var imeiCodeRequestDto = ImeiCodeRequestDto.builder()
                .imeiCodes(List.of("TT11"))
                .orderNo("3123456789")
                .build();

        when(imeiMapper.toImeiCodeRequest(imeiCodeRequestDto)).thenReturn(imeiCodeRequest);

        imeiService.saveImei(imeiCodeRequestDto);

        verify(imeiMapper).toImeiCodeRequest(imeiCodeRequestDto);
    }
}
