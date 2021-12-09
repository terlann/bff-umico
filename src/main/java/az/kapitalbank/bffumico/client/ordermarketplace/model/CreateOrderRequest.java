package az.kapitalbank.bffumico.client.ordermarketplace.model;

import az.kapitalbank.bffumico.dto.OrderProductDeliveryInfo;
import az.kapitalbank.bffumico.dto.OrderProductItem;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateOrderRequest {
    CustomerInfo customerInfo;
    CustomerDetail customerDetail;
    @NotNull
    Integer loanTerm;
    @NotNull
    BigDecimal totalAmount;
    List<OrderProductDeliveryInfo> deliveryInfo;
    List<@Valid OrderProductItem> products;
}
