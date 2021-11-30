package az.kapitalbank.bffumico.dto;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeliveryProductDto {
    String orderNo;
    String productId;
    String itemType;
    BigDecimal lastAmount;
}
