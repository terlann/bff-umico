package az.kapitalbank.bffumico.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import az.kapitalbank.bffumico.dto.OrderProductDeliveryInfo;
import az.kapitalbank.bffumico.dto.OrderProductItem;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateOrderRequestDto {
    String fullName;
    String phoneNumber;
    String pinCode;
    String cardPan;
    String workPlace;
    String email;
    LocalDate birthday;
    Boolean isKbCustomer;
    Boolean isAgreement;
    Integer loanTerm;
    BigDecimal totalAmount;
    String umicoUserId;
    String userIp;
    String umicoRegistrationPhone;
    String userAgent;
    String originationLat;
    String originationLan;
    LocalDate umicoRegistrationDate;
    List<OrderProductDeliveryInfo> deliveryInfo;
    List<OrderProductItem> products;
}
