package az.kapitalbank.bffumico.exception;

import feign.FeignException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public Map<String, Object> handleFeignStatusException(FeignException ex,
                                                          HttpServletResponse response) {
        response.setStatus(ex.status());
        log.error("Exception: {}", ex.contentUTF8());
        return new JSONObject(ex.contentUTF8()).toMap();
    }
}
