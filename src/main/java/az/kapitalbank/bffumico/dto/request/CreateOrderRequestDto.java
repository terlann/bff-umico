package az.kapitalbank.bffumico.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import az.kapitalbank.bffumico.dto.OrderProductDeliveryInfo;
import az.kapitalbank.bffumico.dto.OrderProductItem;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateOrderRequestDto {
    @NotEmpty
    String fullname;
    @NotEmpty
    String phoneNumber;
    @NotEmpty
    String pincode;
    String cardPan;
    String workPlace;
    String email;
    Boolean isKbCustomer;
    Boolean isAgreement;
    Integer loanTerm;
    LocalDate birthday;
    BigDecimal totalAmount;
    String umicoUserId;
    String userIp;
    String umicoRegistrationPhone;
    String userAgent;
    String originationLat;
    String originationLan;
    @NotEmpty
    String additionalPhoneNumber1;
    @NotEmpty
    String additionalPhoneNumber2;
    LocalDate umicoRegistrationDate;
    List<OrderProductDeliveryInfo> deliveryInfo;
    List<OrderProductItem> products;
}
