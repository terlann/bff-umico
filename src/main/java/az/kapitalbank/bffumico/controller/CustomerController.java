package az.kapitalbank.bffumico.controller;

import az.kapitalbank.bffumico.dto.response.BalanceResponseDto;
import az.kapitalbank.bffumico.service.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerController {

    CustomerService customerService;

    @GetMapping("/balance")
    public ResponseEntity<BalanceResponseDto> getCustomerBalance(@RequestParam("umico_user_id") String umicoUserId,
                                                                 @RequestParam("customer_id") String customerId) {
        return customerService.getCustomerBalance(umicoUserId, customerId);
    }

    @GetMapping("/{pin_code}")
    public ResponseEntity<Void> checkCustomerByPin(@PathVariable("pin_code") String pin) {
        return customerService.checkPinCode(pin);
    }

}
