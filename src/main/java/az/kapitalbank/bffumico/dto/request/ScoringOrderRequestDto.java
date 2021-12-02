package az.kapitalbank.bffumico.dto.request;

import java.time.LocalDate;

import az.kapitalbank.bffumico.constant.OrderScoringStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScoringOrderRequestDto {
    String eteOrderId;
    OrderScoringStatus scoringStatus;
    String creditId;
    LocalDate loanStartDate;
    LocalDate loanEndDate;
}
