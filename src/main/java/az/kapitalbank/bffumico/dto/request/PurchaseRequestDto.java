package az.kapitalbank.bffumico.dto.request;

import az.kapitalbank.bffumico.dto.DeliveryProductDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import java.util.UUID;
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
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PurchaseRequestDto {
    String umicoUserId;
    UUID trackId;
    UUID customerId;
    String orderNo;
    List<DeliveryProductDto> deliveryProducts;
}
