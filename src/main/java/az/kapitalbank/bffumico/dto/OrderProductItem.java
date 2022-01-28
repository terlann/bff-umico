package az.kapitalbank.bffumico.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderProductItem {
    Integer productAmount;
    String productId;
    String productName;
    String orderNo;
    String itemType;
    String partnerCmsId;
}
