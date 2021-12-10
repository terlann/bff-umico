package az.kapitalbank.bffumico.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor(staticName = "of")
@RequiredArgsConstructor(staticName = "of")
public class CreateOrderResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String eteOrderId;
    final String marketplaceTrackId;
}