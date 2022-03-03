package az.kapitalbank.bffumico.client.ordermarketplace.model;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderProductItem {
    BigDecimal productAmount;
    String productId;
    String productName;
    String orderNo;
    String itemType;
    String partnerCmsId;
}
