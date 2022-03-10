package az.kapitalbank.bffumico.controller;

import az.kapitalbank.bffumico.dto.request.SendOtpRequestDto;
import az.kapitalbank.bffumico.dto.response.SendOtpResponseDto;
import az.kapitalbank.bffumico.service.OtpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/otp")
public class OtpController {

    OtpService otpService;

    @PostMapping("/send")
    public ResponseEntity<SendOtpResponseDto> send(SendOtpRequestDto requestDto) {
        return ResponseEntity.ok(otpService.send(requestDto));
    }
}
