package az.kapitalbank.bffumico.dto.request;

import az.kapitalbank.bffumico.dto.DeliveryProductDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PurchaseRequestDto {

    String umicoUserId;
    UUID trackId;
    UUID customerId;

    @NotNull
    List<@Valid DeliveryProductDto> deliveryOrders;

}
