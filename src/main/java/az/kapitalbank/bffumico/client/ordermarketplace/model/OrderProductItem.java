package az.kapitalbank.bffumico.client.ordermarketplace.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderProductItem {
    Integer productAmount;
    String productId;
    String productName;
    String orderNo;
    String itemType;
    String partnerCmsId;
}
