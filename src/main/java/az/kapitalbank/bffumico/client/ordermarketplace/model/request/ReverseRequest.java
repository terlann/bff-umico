package az.kapitalbank.bffumico.client.ordermarketplace.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReverseRequest {
    String umicoUserId;
    String customerId;
    String orderNo;
    String orderAmount;
}
