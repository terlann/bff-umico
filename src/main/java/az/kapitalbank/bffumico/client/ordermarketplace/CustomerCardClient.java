package az.kapitalbank.bffumico.client.ordermarketplace;

import az.kapitalbank.bffumico.client.ordermarketplace.model.BalanceResponse;
import az.kapitalbank.bffumico.dto.response.WrapperResponseDto;
import feign.Logger;
import feign.codec.ErrorDecoder;
import feign.error.AnnotationErrorDecoder;
import feign.jackson.JacksonDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "marketplace",
        url = "${client.marketplace.url}",
        primary = false,
        configuration = CustomerCardClient.FeignConfiguration.class)
public interface CustomerCardClient {

    @GetMapping("/customers/{customerId}/balance")
    WrapperResponseDto<BalanceResponse> getCustomerBalance(String customerId);

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
