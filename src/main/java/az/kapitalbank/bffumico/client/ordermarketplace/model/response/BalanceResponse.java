package az.kapitalbank.bffumico.client.ordermarketplace.model.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BalanceResponse {
    LocalDateTime cardExpiryDate;
    BigDecimal loanLimit;
    BigDecimal loanUtilized;
    BigDecimal availableBalance;
}
