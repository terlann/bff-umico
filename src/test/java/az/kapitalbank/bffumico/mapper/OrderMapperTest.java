package az.kapitalbank.bffumico.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import az.kapitalbank.bffumico.client.ordermarketplace.model.CustomerInfo;
import az.kapitalbank.bffumico.client.ordermarketplace.model.OrderProductDeliveryInfo;
import az.kapitalbank.bffumico.client.ordermarketplace.model.OrderProductItem;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.CreateOrderRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.PurchaseRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.RefundRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.CheckOrderResponse;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.CreateOrderResponse;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.PurchaseResponse;
import az.kapitalbank.bffumico.dto.CustomerInfoDto;
import az.kapitalbank.bffumico.dto.OrderProductDeliveryInfoDto;
import az.kapitalbank.bffumico.dto.OrderProductItemDto;
import az.kapitalbank.bffumico.dto.request.CreateOrderRequestDto;
import az.kapitalbank.bffumico.dto.request.PurchaseRequestDto;
import az.kapitalbank.bffumico.dto.request.RefundRequestDto;
import az.kapitalbank.bffumico.dto.response.CheckOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.CreateOrderResponseDto;
import az.kapitalbank.bffumico.dto.response.PurchaseResponseDto;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@SpringBootTest(classes = OrderMapperImpl.class)
class OrderMapperTest {

    @Autowired
    OrderMapper orderMapper;

    @Test
    void toCreateOrderRequest() {
        var createOrderRequestDto = getCreateOrderRequestDto();
        var expected = getCreateOrderRequest(createOrderRequestDto);

        var actual = orderMapper.toCreateOrderRequest(createOrderRequestDto);

        assertEquals(expected, actual);
    }

    @Test
    void toCreateOrderResponseDto() {
        var createOrderResponse = CreateOrderResponse.builder().build();
        var expected = CreateOrderResponseDto.builder().build();

        var actual = orderMapper.toCreateOrderResponseDto(createOrderResponse);

        assertEquals(expected, actual);

    }

    @Test
    void toCheckOrderResponseDto() {
        var checkOrderResponse = CheckOrderResponse.builder().build();
        var expected = CheckOrderResponseDto.builder().build();

        var actual = orderMapper.toCheckOrderResponseDto(checkOrderResponse);

        assertEquals(expected, actual);
    }

    @Test
    void toRefundRequest() {
        var refundRequestDto = RefundRequestDto.builder().build();
        var expected = RefundRequest.builder().build();

        var actual = orderMapper.toRefundRequest(refundRequestDto);

        assertEquals(expected, actual);
    }

    @Test
    void toPurchaseRequest() {
        var purchaseRequestDto = PurchaseRequestDto.builder().build();
        var expected = PurchaseRequest.builder().build();

        var actual = orderMapper.toPurchaseRequest(purchaseRequestDto);

        assertEquals(expected, actual);
    }

    @Test
    void toPurchaseResponseDto() {
        var purchaseResponse = PurchaseResponse.builder().build();
        var expected = PurchaseResponseDto.builder().build();

        var actual = orderMapper.toPurchaseResponseDto(purchaseResponse);

        assertEquals(expected, actual);
    }

    @Test
    void toPurchaseResponseDtoList() {
        var purchaseResponse = PurchaseResponse.builder().build();
        var expected = List.of(PurchaseResponseDto.builder().build());

        var actual = orderMapper.toPurchaseResponseDtoList(List.of(purchaseResponse));

        assertEquals(expected, actual);
    }

    private CreateOrderRequestDto getCreateOrderRequestDto() {
        var orderProductDeliveryInfoDto = OrderProductDeliveryInfoDto.builder()
                .orderNo("123456")
                .deliveryMethod("")
                .deliveryAddress("")
                .shippingLatitude("")
                .shippingLongitude("")
                .totalAmount(BigDecimal.ONE)
                .build();

        var orderProductItemDto = OrderProductItemDto.builder()
                .productAmount(BigDecimal.ONE)
                .productId("")
                .productName("")
                .orderNo("")
                .itemType("")
                .partnerCmsId("")
                .categoryId(1)
                .brand("")
                .build();

        return CreateOrderRequestDto.builder()
                .customerInfo(getCustomerInfoDto())
                .loanTerm(1)
                .totalAmount(BigDecimal.ONE)
                .deliveryInfo(List.of(orderProductDeliveryInfoDto))
                .products(List.of(orderProductItemDto))
                .build();
    }

    private CustomerInfoDto getCustomerInfoDto() {
        return CustomerInfoDto.builder()
                .umicoUserId("")
                .customerId(UUID.randomUUID())
                .fullName("")
                .mobileNumber("")
                .pin("")
                .email("")
                .isAgreement(true)
                .workPlace("")
                .birthday(LocalDate.MIN)
                .additionalPhoneNumber1("")
                .additionalPhoneNumber2("")
                .latitude("")
                .longitude("")
                .ip("")
                .userAgent("")
                .deviceTokenId("")
                .birbankUserId(12345)
                .birbankDeviceId("")
                .build();
    }


    private CreateOrderRequest getCreateOrderRequest(CreateOrderRequestDto request) {
        var orderProductDeliveryInfo = OrderProductDeliveryInfo.builder()
                .orderNo(request.getDeliveryInfo().get(0).getOrderNo())
                .deliveryMethod(request.getDeliveryInfo().get(0).getDeliveryMethod())
                .deliveryAddress(request.getDeliveryInfo().get(0).getDeliveryAddress())
                .shippingLatitude(request.getDeliveryInfo().get(0).getShippingLatitude())
                .shippingLongitude(request.getDeliveryInfo().get(0).getShippingLongitude())
                .totalAmount(request.getDeliveryInfo().get(0).getTotalAmount())
                .build();

        var orderProductItem = OrderProductItem.builder()
                .productAmount(request.getProducts().get(0).getProductAmount())
                .productId(request.getProducts().get(0).getProductId())
                .productName(request.getProducts().get(0).getProductName())
                .orderNo(request.getProducts().get(0).getOrderNo())
                .itemType(request.getProducts().get(0).getItemType())
                .partnerCmsId(request.getProducts().get(0).getPartnerCmsId())
                .categoryId(request.getProducts().get(0).getCategoryId())
                .brand(request.getProducts().get(0).getBrand())
                .build();

        CustomerInfo customerInfo =
                getCustomerInfo(request);

        return CreateOrderRequest.builder()
                .customerInfo(customerInfo)
                .loanTerm(1)
                .totalAmount(BigDecimal.ONE)
                .deliveryInfo(List.of(orderProductDeliveryInfo))
                .products(List.of(orderProductItem))
                .build();
    }

    private CustomerInfo getCustomerInfo(CreateOrderRequestDto request) {
        return CustomerInfo.builder()
                .umicoUserId(request.getCustomerInfo().getUmicoUserId())
                .customerId(request.getCustomerInfo().getCustomerId())
                .fullName(request.getCustomerInfo().getFullName())
                .mobileNumber(request.getCustomerInfo().getMobileNumber())
                .pin(request.getCustomerInfo().getPin())
                .email(request.getCustomerInfo().getEmail())
                .isAgreement(request.getCustomerInfo().getIsAgreement())
                .workPlace(request.getCustomerInfo().getWorkPlace())
                .birthday(request.getCustomerInfo().getBirthday())
                .additionalPhoneNumber1(request.getCustomerInfo().getAdditionalPhoneNumber1())
                .additionalPhoneNumber2(request.getCustomerInfo().getAdditionalPhoneNumber2())
                .latitude(request.getCustomerInfo().getLatitude())
                .longitude(request.getCustomerInfo().getLongitude())
                .ip(request.getCustomerInfo().getIp())
                .userAgent(request.getCustomerInfo().getUserAgent())
                .deviceTokenId(request.getCustomerInfo().getDeviceTokenId())
                .birbankUserId(request.getCustomerInfo().getBirbankUserId())
                .birbankDeviceId(request.getCustomerInfo().getBirbankDeviceId())
                .build();
    }
}
