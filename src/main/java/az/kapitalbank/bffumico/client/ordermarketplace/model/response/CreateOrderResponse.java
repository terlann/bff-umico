package az.kapitalbank.bffumico.client.ordermarketplace.model.response;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateOrderResponse {

    String eteOrderId;
    UUID trackId;

}
