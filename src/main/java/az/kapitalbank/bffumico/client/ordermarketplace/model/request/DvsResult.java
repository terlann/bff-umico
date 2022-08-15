package az.kapitalbank.bffumico.client.ordermarketplace.model.request;

import az.kapitalbank.libdvs.client.model.verification.Step;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class DvsResult {
    @JsonProperty("steps")
    Step step;
    String personOrderId;
}
