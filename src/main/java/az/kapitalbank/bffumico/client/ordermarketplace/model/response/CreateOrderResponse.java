package az.kapitalbank.bffumico.client.ordermarketplace.model.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateOrderResponse {

    String eteOrderId;
    String marketplaceTrackId;

}
