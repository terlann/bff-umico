package az.kapitalbank.bffumico.controller;

import az.kapitalbank.bffumico.dto.response.WrapperResponseDto;
import az.kapitalbank.bffumico.service.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/marketplace")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {

    CustomerService customerService;

    @GetMapping("/customers/{customerId}/balance")
    public ResponseEntity<WrapperResponseDto<Object>> getCustomerBalance(@PathVariable String customerId) {
        return ResponseEntity.ok(customerService.getCustomerBalance(customerId));
    }

}
