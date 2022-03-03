package az.kapitalbank.bffumico.client.ordermarketplace.model;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeliveryProduct {
    String orderNo;
    String productId;
    String itemType;
    BigDecimal orderAmount;
}
