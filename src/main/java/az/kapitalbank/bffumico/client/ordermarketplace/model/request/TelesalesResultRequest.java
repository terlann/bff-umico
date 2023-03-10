package az.kapitalbank.bffumico.client.ordermarketplace.model.request;

import az.kapitalbank.bffumico.constant.ScoringStatus;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TelesalesResultRequest {
    String telesalesOrderId;
    ScoringStatus scoringStatus;
    LocalDate loanContractStartDate;
    LocalDate loanContractEndDate;
    String uid;
    String pan;
    BigDecimal scoredAmount;
    Long rejectReasonCode;
    String cif;
    String contractNumber;
}
