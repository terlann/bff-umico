package az.kapitalbank.bffumico.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.TelesalesResultRequest;
import az.kapitalbank.bffumico.dto.request.TelesalesResultRequestDto;
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
        var telesalesResultRequestDto = TelesalesResultRequestDto.builder().build();
        var expected = TelesalesResultRequest.builder().build();

        var actual = scoringMapper.toScoringOrderRequest(telesalesResultRequestDto);

        assertEquals(expected, actual);
    }
}
