package az.kapitalbank.bffumico.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.DvsResult;
import az.kapitalbank.bffumico.dto.request.DvsResultDto;
import az.kapitalbank.libdvs.client.model.verification.Step;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@SpringBootTest(classes = DvsMapperImpl.class)
class DvsMapperTest {

    @Autowired
    DvsMapper dvsMapper;

    @Test
    void toDvsResult() {
        var step = Step.builder()
                .id("face-id")
                .status("confirmed")
                .build();
        var dvsResultDto = DvsResultDto.builder()
                .personOrderId("12345")
                .step(step)
                .build();

        var expected = DvsResult.builder()
                .personOrderId(dvsResultDto.getPersonOrderId())
                .step(step)
                .build();

        var actual = dvsMapper.toDvsResult(dvsResultDto);

        assertEquals(expected, actual);
    }
}
