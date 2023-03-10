package az.kapitalbank.bffumico.controller;

import az.kapitalbank.bffumico.dto.response.BalanceResponseDto;
import az.kapitalbank.bffumico.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
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
    @ApiOperation("Check Balance")
    public ResponseEntity<BalanceResponseDto> getCustomerBalance(
            @RequestParam("umico_user_id") String umicoUserId,
            @RequestParam("customer_id") UUID customerId) {
        return ResponseEntity.ok(customerService.getCustomerBalance(umicoUserId, customerId));
    }

    @GetMapping("check/{pin}")
    @ApiOperation("Check Customer By Pin")
    public ResponseEntity<Void> checkPin(@PathVariable String pin) {
        customerService.checkPin(pin);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
