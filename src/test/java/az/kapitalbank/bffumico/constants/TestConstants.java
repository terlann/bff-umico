package az.kapitalbank.bffumico.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TestConstants {
    PIN("1234567"),
    MOBILE_NUMBER("0551234567"),
    TRACK_ID("3a30a65a-9bec-11ec-b909-0242ac120002"),
    CUSTOMER_ID("30d8c6d0-a0fd-11ec-b909-0242ac120002"),
    UMICO_USER_ID("30d8c6d0-3242-11ec-b909-0242ac120002"),
    TELESALES_ORDER_ID("eb813fa4-a142-11ec-b909-0242ac120002");

    final String value;

}
