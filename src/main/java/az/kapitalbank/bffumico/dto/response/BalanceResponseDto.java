package az.kapitalbank.bffumico.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BalanceResponseDto {

    String accountNumber;
    String availableBalance;
    int currency;
    int overdraftLimit;

}
