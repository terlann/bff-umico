package az.kapitalbank.bffumico.client.ordermarketplace.model.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BalanceResponse {
    private LocalDateTime cardExpiryDate;
    private BigDecimal loanLimit;
    private BigDecimal loanUtilized;
    private BigDecimal availableBalance;
}
