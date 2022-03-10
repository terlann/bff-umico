package az.kapitalbank.bffumico.client.ordermarketplace.model.request;

import az.kapitalbank.bffumico.client.ordermarketplace.model.DeliveryProduct;
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
public class PurchaseRequest {
    String umicoUserId;
    UUID trackId;
    UUID customerId;
    List<DeliveryProduct> deliveryOrders;
}
