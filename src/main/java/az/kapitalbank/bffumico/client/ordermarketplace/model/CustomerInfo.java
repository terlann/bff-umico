package az.kapitalbank.bffumico.client.ordermarketplace.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CustomerInfo {
    @NotEmpty
    String fullname;
    @NotEmpty
    @Pattern(regexp = "^\\+994[0-9]{9}$")
    String phoneNumber;
    @NotEmpty
    @Pattern(regexp = "\\w{7}")
    String pincode;
    @NotEmpty
    @Pattern(regexp = "^(.+)@(.+)$")
    String email;
    @NotNull
    boolean isAgreement;
    String workPlace;
    @NotEmpty
    String additionalPhoneNumber1;
    @NotEmpty
    String additionalPhoneNumber2;
}
