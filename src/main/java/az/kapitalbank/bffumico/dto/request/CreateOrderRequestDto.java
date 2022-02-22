package az.kapitalbank.bffumico.dto.request;

import java.math.BigDecimal;
import java.util.List;

import az.kapitalbank.bffumico.dto.CustomerInfoDto;
import az.kapitalbank.bffumico.dto.OrderProductDeliveryInfoDto;
import az.kapitalbank.bffumico.dto.OrderProductItemDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateOrderRequestDto {

    CustomerInfoDto customerInfo;
    Integer loanTerm;
    BigDecimal totalAmount;
    List<OrderProductDeliveryInfoDto> deliveryInfo;
    List<OrderProductItemDto> products;

}
