package az.kapitalbank.bffumico.controller;

import az.kapitalbank.bffumico.dto.request.SendOtpRequestDto;
import az.kapitalbank.bffumico.dto.request.VerifyOtpRequestDto;
import az.kapitalbank.bffumico.dto.response.SendOtpResponseDto;
import az.kapitalbank.bffumico.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/otp")
public class OtpController {

    private final OtpService otpService;

    @PostMapping("/send")
    public ResponseEntity<SendOtpResponseDto> send(@RequestBody SendOtpRequestDto requestDto) {
        return ResponseEntity.ok(otpService.send(requestDto));
    }

    @PostMapping("/verify")
    public ResponseEntity<Void> verify(@RequestBody VerifyOtpRequestDto requestDto) {
        otpService.verify(requestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
