package az.kapitalbank.bffumico.client.ordermarketplace;

import az.kapitalbank.bffumico.client.ordermarketplace.model.CreateOrderRequest;
import az.kapitalbank.bffumico.dto.request.DeliveryProductRequestDto;
import az.kapitalbank.bffumico.dto.request.ScoringOrderRequestDto;
import az.kapitalbank.bffumico.dto.response.WrapperResponseDto;
import feign.Logger;
import feign.codec.ErrorDecoder;
import feign.error.AnnotationErrorDecoder;
import feign.jackson.JacksonDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "order-marketplace",
        url = "${client.order-marketplace.url}",
        primary = false,
        configuration = OrderMarketplaceClient.FeignConfiguration.class)
public interface OrderMarketplaceClient {

    @GetMapping("/v1/marketplace/order/check")
    WrapperResponseDto<Object> checkOrder(@RequestParam("eteOrderId") String eteOrderId);

    @PostMapping("/v1/marketplace/delivery")
    WrapperResponseDto<Object> deliveryProducts(@RequestBody DeliveryProductRequestDto request);

    @PostMapping("/v1/marketplace/order")
    WrapperResponseDto<Object> createOrder(@RequestBody CreateOrderRequest request);

    @DeleteMapping("/v1/marketplace/order")
    WrapperResponseDto<Object> deleteOrder(@RequestParam String trackId);

    @PostMapping("/v1/marketplace/scoring")
    WrapperResponseDto<Object> scoringOrder(@RequestBody ScoringOrderRequestDto request);

    @GetMapping("/v1/marketplace/check/{pinCode}/customer")
    WrapperResponseDto<Object> checkPinCode(@PathVariable String pinCode);


    class FeignConfiguration {
        @Bean
        Logger.Level loggerLevel() {
            return Logger.Level.BASIC;
        }

        @Bean
        public ErrorDecoder feignErrorDecoder() {
            return AnnotationErrorDecoder.builderFor(OrderMarketplaceClient.class)
                    .withResponseBodyDecoder(new JacksonDecoder())
                    .build();
        }
    }
}
