package az.kapitalbank.bffumico.client.ordermarketplace;

import java.util.UUID;

import az.kapitalbank.bffumico.client.ordermarketplace.model.response.BalanceResponse;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "marketplace",
        url = "${client.marketplace.url}/api/v1",
        primary = false)
public interface CustomerCardClient {

    @GetMapping("/customers/balance")
    BalanceResponse getCustomerBalance(@RequestParam String umicoUserId, @RequestParam UUID customerId);

    @GetMapping("/customers/check/{pin}")
    void checkPin(@PathVariable String pin);

    class FeignConfiguration {
        @Bean
        Logger.Level loggerLevel() {
            return Logger.Level.BASIC;
        }

    }
}
