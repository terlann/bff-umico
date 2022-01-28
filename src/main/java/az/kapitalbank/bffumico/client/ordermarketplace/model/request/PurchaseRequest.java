package az.kapitalbank.bffumico.client.ordermarketplace.model.request;

import az.kapitalbank.bffumico.dto.DeliveryProductDto;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseRequest {
    String umicoUserId;
    UUID trackId;
    UUID customerId;

    @NotNull
    List<@Valid DeliveryProductDto> deliveryOrders;
}
