package az.kapitalbank.bffumico.client.ordermarketplace.model.request;

import az.kapitalbank.bffumico.dto.CustomerInfoDto;
import az.kapitalbank.bffumico.dto.OrderProductDeliveryInfo;
import az.kapitalbank.bffumico.dto.OrderProductItem;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    CustomerInfoDto customerInfo;
    @NotNull
    Integer loanTerm;
    @NotNull
    BigDecimal totalAmount;
    List<OrderProductDeliveryInfo> deliveryInfo;
    List<@Valid OrderProductItem> products;
}
