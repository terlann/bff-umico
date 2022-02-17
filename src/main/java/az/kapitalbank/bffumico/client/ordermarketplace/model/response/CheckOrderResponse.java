package az.kapitalbank.bffumico.client.ordermarketplace.model.response;

import java.math.BigDecimal;
import java.util.UUID;

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

    String telesalesOrderId;
    UUID trackId;
    BigDecimal totalAmount;

}
