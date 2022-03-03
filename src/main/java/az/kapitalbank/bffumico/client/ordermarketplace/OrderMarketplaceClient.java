package az.kapitalbank.bffumico.client.ordermarketplace;

import java.util.List;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.CreateOrderRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.PurchaseRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.ReverseRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.TelesalesResultRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.CheckOrderResponse;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.CreateOrderResponse;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.PurchaseResponse;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-marketplace",
        url = "${client.marketplace.url}/api/v1",
        primary = false)
public interface OrderMarketplaceClient {

    @PostMapping("/orders")
    CreateOrderResponse createOrder(@RequestBody CreateOrderRequest request);

    @PostMapping("/orders/check/{telesales-order-id}")
    CheckOrderResponse checkOrder(@PathVariable("telesales-order-id") String telesalesOrderId);

    @PostMapping("/orders/telesales/result")
    void telesalesResult(@RequestBody TelesalesResultRequest request);

    @PostMapping("/orders/purchase")
    List<PurchaseResponse> purchase(@RequestBody PurchaseRequest request);

    @PostMapping("/orders/reverse")
    PurchaseResponse reverseOrder(@RequestBody ReverseRequest request);

    class FeignConfiguration {
        @Bean
        Logger.Level loggerLevel() {
            return Logger.Level.BASIC;
        }

    }
}
