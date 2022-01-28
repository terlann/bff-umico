package az.kapitalbank.bffumico.client.ordermarketplace.model.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BalanceResponse {

    LocalDate loanEndDate;
    BigDecimal loanLimit;
    BigDecimal loanUtilized;
    BigDecimal loanAvailable;

}
