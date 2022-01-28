package az.kapitalbank.bffumico.client.ordermarketplace.model.request;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReverseRequest {
    String umicoUserId;
    UUID customerId;
    String orderNo;
    String orderAmount;
}
