package az.kapitalbank.bffumico.dto.request;

import java.time.LocalDate;

import az.kapitalbank.bffumico.constant.ScoringStatus;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ScoringOrderRequestDto {
    String telesalesOrderId;
    ScoringStatus scoringStatus;
    LocalDate loanStartDate;
    LocalDate loanEndDate;
    String pan;
}
