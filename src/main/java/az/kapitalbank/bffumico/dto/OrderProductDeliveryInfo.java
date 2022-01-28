package az.kapitalbank.bffumico.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderProductDeliveryInfo {
    String orderNo;
    String deliveryMethod;
    String deliveryAddress;
    String shippingLatitude;
    String shippingLongitude;
    BigDecimal totalAmount;
}
