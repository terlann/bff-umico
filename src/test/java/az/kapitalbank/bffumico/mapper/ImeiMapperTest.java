package az.kapitalbank.bffumico.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.ImeiCodeRequest;
import az.kapitalbank.bffumico.dto.request.ImeiCodeRequestDto;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@SpringBootTest(classes = ImeiMapperImpl.class)
class ImeiMapperTest {

    @Autowired
    ImeiMapper imeiMapper;

    @Test
    void toImeiCodeRequest() {
        var imeiCodeRequestDto = ImeiCodeRequestDto.builder()
                .orderNo("123456")
                .imeiCodes(List.of("51632915709789")).build();
        var expected = ImeiCodeRequest.builder()
                .orderNo(imeiCodeRequestDto.getOrderNo())
                .imeiCodes(imeiCodeRequestDto.getImeiCodes()).build();

        var actual = imeiMapper.toImeiCodeRequest(imeiCodeRequestDto);

        assertEquals(expected, actual);
    }
}
