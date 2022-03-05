package az.kapitalbank.bffumico.client.ordermarketplace.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendOtpResponse {
    String message;
    String maskedMobileNum;
}
