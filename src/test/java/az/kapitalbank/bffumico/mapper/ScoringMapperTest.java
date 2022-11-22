package az.kapitalbank.bffumico.mapper;

import static az.kapitalbank.bffumico.constants.TestConstants.CIF;
import static az.kapitalbank.bffumico.constants.TestConstants.CONTRACT_NUMBER;
import static az.kapitalbank.bffumico.constants.TestConstants.TELESALES_ORDER_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.TelesalesResultRequest;
import az.kapitalbank.bffumico.dto.request.TelesalesResultRequestDto;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@SpringBootTest(classes = ScoringMapperImpl.class)
class ScoringMapperTest {

    @Autowired
    ScoringMapper scoringMapper;

    @Test
    void toScoringOrderRequest() {
        var telesalesResultRequestDto =
                TelesalesResultRequestDto.builder().telesalesOrderId(TELESALES_ORDER_ID.getValue())
                        .cif(
                                CIF.getValue()).contractNumber(CONTRACT_NUMBER.getValue())
                        .scoredAmount(BigDecimal.TEN).build();
        var expected =
                TelesalesResultRequest.builder().telesalesOrderId(TELESALES_ORDER_ID.getValue())
                        .cif(
                                CIF.getValue()).contractNumber(CONTRACT_NUMBER.getValue())
                        .scoredAmount(BigDecimal.TEN).build();

        var actual = scoringMapper.toScoringOrderRequest(telesalesResultRequestDto);

        assertEquals(expected, actual);
    }
}
