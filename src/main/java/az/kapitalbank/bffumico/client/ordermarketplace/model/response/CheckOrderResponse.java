package az.kapitalbank.bffumico.client.ordermarketplace.model.response;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CheckOrderResponse {

    String eteOrderId;
    String trackId;
    BigDecimal totalAmount;

}
