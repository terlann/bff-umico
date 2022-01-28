package az.kapitalbank.bffumico.client.ordermarketplace.model.request;

import az.kapitalbank.bffumico.constant.OrderScoringStatus;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScoringOrderRequest {
    String eteOrderId;
    OrderScoringStatus scoringStatus;
    LocalDate loanStartDate;
    LocalDate loanEndDate;
    UUID cardUUID;
}
