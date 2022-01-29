package az.kapitalbank.bffumico.client.ordermarketplace.model.request;

import az.kapitalbank.bffumico.client.ordermarketplace.model.DeliveryProduct;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseRequest {
    String umicoUserId;
    UUID trackId;
    UUID customerId;

    List<DeliveryProduct> deliveryOrders;
}
