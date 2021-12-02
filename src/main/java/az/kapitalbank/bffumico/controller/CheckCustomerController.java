package az.kapitalbank.bffumico.controller;

import az.kapitalbank.bffumico.service.CheckCustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/marketplace/check")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CheckCustomerController {

    CheckCustomerService service;

    @GetMapping("/{pinCode}/customer")
    public ResponseEntity<?> checkPinCode(@PathVariable("pinCode") String pinCode) {
        return ResponseEntity.ok(service.checkPinCode(pinCode));
    }

}
