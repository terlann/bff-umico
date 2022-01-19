package az.kapitalbank.bffumico.client.ordermarketplace.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BalanceResponse {

    String accountNumber;
    String availableBalance;
    int currency;
    int overdraftLimit;

}
