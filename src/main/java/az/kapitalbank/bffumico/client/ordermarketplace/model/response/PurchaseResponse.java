package az.kapitalbank.bffumico.client.ordermarketplace.model.response;

import az.kapitalbank.bffumico.constant.OrderStatus;
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
public class PurchaseResponse {
    String orderNo;
    OrderStatus status;
}
