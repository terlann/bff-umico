package az.kapitalbank.bffumico.client.ordermarketplace.model.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BalanceResponse {

    LocalDate loanEndDate;
    String loanLimit;
    String loanUtilized;
    String loanAvailable;

}
