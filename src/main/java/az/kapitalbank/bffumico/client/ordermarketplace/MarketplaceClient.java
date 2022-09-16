package az.kapitalbank.bffumico.client.ordermarketplace;

import az.kapitalbank.bffumico.client.ordermarketplace.model.request.CreateOrderRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.DvsResult;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.ImeiCodeRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.PurchaseRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.RefundRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.SendOtpRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.TelesalesResultRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.request.VerifyOtpRequest;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.CheckOrderResponse;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.CreateOrderResponse;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.PurchaseResponse;
import az.kapitalbank.bffumico.client.ordermarketplace.model.response.SendOtpResponse;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-marketplace",
        url = "${client.marketplace.url}/api/v1",
        primary = false)
public interface MarketplaceClient {

    @PostMapping("/orders")
    CreateOrderResponse create(@RequestBody CreateOrderRequest request);

    @PostMapping("/orders/check/{telesales-order-id}")
    CheckOrderResponse check(@PathVariable("telesales-order-id") String telesalesOrderId);

    @PostMapping("/orders/telesales/result")
    void telesalesResult(@RequestBody TelesalesResultRequest request);

    @PostMapping("/orders/purchase")
    void purchase(@RequestBody PurchaseRequest request);

    @PostMapping("/orders/refund")
    PurchaseResponse refundOrder(@RequestBody RefundRequest request);

    @PostMapping("/otp/send")
    SendOtpResponse send(@RequestBody SendOtpRequest request);

    @PostMapping("/otp/verify")
    void verify(@RequestBody VerifyOtpRequest request);

    @PostMapping("/dvs/result")
    void verificationResult(@RequestBody DvsResult request);

    @PostMapping("/imei")
    void saveImeiCode(@RequestBody ImeiCodeRequest imeiCodeRequest);

    class FeignConfiguration {
        @Bean
        Logger.Level loggerLevel() {
            return Logger.Level.BASIC;
        }

    }
}
