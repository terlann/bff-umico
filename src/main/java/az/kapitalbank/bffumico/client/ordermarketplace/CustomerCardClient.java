package az.kapitalbank.bffumico.client.ordermarketplace;

import az.kapitalbank.bffumico.client.ordermarketplace.model.response.BalanceResponse;
import feign.Logger;
import feign.codec.ErrorDecoder;
import feign.error.AnnotationErrorDecoder;
import feign.jackson.JacksonDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "marketplace",
        url = "${client.marketplace.url}/api/v1",
        primary = false,
        configuration = CustomerCardClient.FeignConfiguration.class)
public interface CustomerCardClient {

    @GetMapping("/customers/balance")
    ResponseEntity<BalanceResponse> getCustomerBalance(@RequestParam String umicoUserId,
                                                       @RequestParam String customerId);

    @GetMapping("/customers/{pin}")
    ResponseEntity<Void> checkPin(@PathVariable String pin);

    class FeignConfiguration {
        @Bean
        Logger.Level loggerLevel() {
            return Logger.Level.BASIC;
        }

        @Bean
        public ErrorDecoder feignErrorDecoder() {
            return AnnotationErrorDecoder.builderFor(CustomerCardClient.class)
                    .withResponseBodyDecoder(new JacksonDecoder())
                    .build();
        }
    }
}
