package az.kapitalbank.bffumico.client.ordermarketplace.model;

import java.math.BigDecimal;
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
public class OrderProductDeliveryInfo {
    String orderNo;
    String deliveryMethod;
    String deliveryAddress;
    String shippingLatitude;
    String shippingLongitude;
    BigDecimal totalAmount;
}
