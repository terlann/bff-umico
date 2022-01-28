package az.kapitalbank.bffumico.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BalanceRequestDto {

    String umicoUserId;
    String customerId;

}
