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
public class OrderProductItem {
    BigDecimal productAmount;
    String productId;
    String productName;
    String orderNo;
    String itemType;
    String partnerCmsId;
    Integer categoryId;
    String brand;
}
