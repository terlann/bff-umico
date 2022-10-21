package az.kapitalbank.bffumico.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import az.kapitalbank.bffumico.client.ordermarketplace.model.response.BalanceResponse;
import az.kapitalbank.bffumico.dto.response.BalanceResponseDto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@SpringBootTest(classes = CustomerMapperImpl.class)
class CustomerMapperTest {

    @Autowired
    CustomerMapper customerMapper;

    @Test
    void toBalanceResponseDto() {
        var balanceResponse = BalanceResponse.builder()
                .cardExpiryDate(LocalDateTime.now())
                .loanLimit(BigDecimal.ONE)
                .loanUtilized(BigDecimal.ONE)
                .availableBalance(BigDecimal.ONE)
                .build();
        var expected = BalanceResponseDto.builder()
                .loanEndDate(balanceResponse.getCardExpiryDate().toLocalDate())
                .loanLimit(balanceResponse.getLoanLimit())
                .loanUtilized(balanceResponse.getLoanUtilized())
                .availableBalance(balanceResponse.getAvailableBalance())
                .build();

        var actual = customerMapper.toBalanceResponseDto(balanceResponse);

        assertEquals(expected, actual);
    }
}
