package az.kapitalbank.bffumico.client.ordermarketplace;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.CreateOrderRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.ReverseRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.CheckOrderResponse;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.CreateOrderResponse;
import az.kapitalbank.bffumico.dto.request.PurchaseRequestDto;
import az.kapitalbank.bffumico.dto.request.ScoringOrderRequestDto;
import feign.Logger;
import feign.codec.ErrorDecoder;
import feign.error.AnnotationErrorDecoder;
import feign.jackson.JacksonDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ms-marketplace",
        url = "${client.marketplace.url}/api/v1",
        primary = false,
        configuration = OrderMarketplaceClient.FeignConfiguration.class)
public interface OrderMarketplaceClient {

    @PostMapping("/orders")
    ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest request);

    @DeleteMapping("/orders/{trackId}")
    ResponseEntity<Void> deleteOrder(@PathVariable String trackId);

    @PostMapping("/orders/purchase")
    ResponseEntity<Void> purchase(@RequestBody PurchaseRequestDto request);

    @PostMapping("/orders/reverse")
    ResponseEntity<Void> reverseOrder(@RequestBody ReverseRequest request);

    @PostMapping("/orders/check")
    ResponseEntity<CheckOrderResponse> checkOrder(@RequestParam("eteOrderId") String eteOrderId);

    @PostMapping("/scoring")
    ResponseEntity<Void> scoringOrder(@RequestBody ScoringOrderRequestDto request);

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
