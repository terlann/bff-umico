package az.kapitalbank.bffumico.client.ordermarketplace.model.request;

import java.time.LocalDate;

import az.kapitalbank.bffumico.constant.ScoringStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TelesalesResultRequest {
    String telesalesOrderId;
    ScoringStatus scoringStatus;
    LocalDate loanStartDate;
    LocalDate loanEndDate;
    String pan;
}
