package az.kapitalbank.bffumico.dto.request;

import az.kapitalbank.bffumico.dto.CustomerInfoDto;
import az.kapitalbank.bffumico.dto.OrderProductDeliveryInfoDto;
import az.kapitalbank.bffumico.dto.OrderProductItemDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateOrderRequestDto {

    CustomerInfoDto customerInfo;
    @NotNull
    Integer loanTerm;
    @NotNull
    BigDecimal totalAmount;
    List<OrderProductDeliveryInfoDto> deliveryInfo;
    List<@Valid OrderProductItemDto> products;

}
