package az.kapitalbank.bffumico.client.ordermarketplace.model.decoder;

import az.kapitalbank.bffumico.exception.ErrorResponse;
import az.kapitalbank.bffumico.exception.UmicoException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerCardClientExceptionDecoder implements ErrorDecoder {

    @SneakyThrows
    @Override
    public Exception decode(String methodKey, Response response) {
        var errorResponse =
                new ObjectMapper().readValue(response.body().asInputStream(), ErrorResponse.class);
        return new UmicoException(errorResponse.getCode(), errorResponse.getMessage());
    }
}
