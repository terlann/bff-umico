package az.kapitalbank.bffumico.client.ordermarketplace.model.request;

import az.kapitalbank.bffumico.client.ordermarketplace.model.CustomerInfo;
import az.kapitalbank.bffumico.client.ordermarketplace.model.OrderProductDeliveryInfo;
import az.kapitalbank.bffumico.client.ordermarketplace.model.OrderProductItem;
import java.math.BigDecimal;
import java.util.List;
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
public class CreateOrderRequest {
    CustomerInfo customerInfo;
    Integer loanTerm;
    BigDecimal totalAmount;
    List<OrderProductDeliveryInfo> deliveryInfo;
    List<OrderProductItem> products;
}
