package az.kapitalbank.bffumico.dto.request;

import az.kapitalbank.bffumico.constant.OrderScoringStatus;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ScoringOrderRequestDto {
    String eteOrderId;
    OrderScoringStatus scoringStatus;
    String creditId;
    LocalDate loanStartDate;
    LocalDate loanEndDate;
    UUID cardUUID;
}
