package az.kapitalbank.bffumico.client.ordermarketplace.model;

import java.time.LocalDate;
import java.util.UUID;
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
public class CustomerInfo {
    String umicoUserId;
    UUID customerId;
    LocalDate registrationDate;
    String fullName;
    String mobileNumber;
    String pin;
    String email;
    Boolean isAgreement;
    String workPlace;
    LocalDate birthday;
    String additionalPhoneNumber1;
    String additionalPhoneNumber2;
    String latitude;
    String longitude;
    String ip;
    String userAgent;
}
