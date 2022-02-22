package az.kapitalbank.bffumico.client.ordermarketplace.model.response;

import az.kapitalbank.bffumico.constant.OrderStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseResponse {
    String orderNo;
    OrderStatus status;
}
