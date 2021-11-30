package az.kapitalbank.bffumico.dto.request;

import java.util.List;

import az.kapitalbank.bffumico.dto.DeliveryProductDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeliveryProductRequestDto {
    String marketplaceTrackId;
    String eteOrderId;
    @JsonProperty("delivery_products")
    List<DeliveryProductDto> products;
}
