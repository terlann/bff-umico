package az.kapitalbank.bffumico.dto.request;

import java.util.List;
import java.util.UUID;

import az.kapitalbank.bffumico.client.ordermarketplace.model.DeliveryProduct;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
    List<DeliveryProduct> deliveryOrders;

}
