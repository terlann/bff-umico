package az.kapitalbank.bffumico.controller;

import static lombok.AccessLevel.PRIVATE;

import az.kapitalbank.bffumico.dto.request.DvsResultDto;
import az.kapitalbank.bffumico.service.DvsService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dvs")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class DvsController {

    DvsService dvsService;

    @PostMapping("/result")
    public ResponseEntity<Void> verificationResult(@RequestBody DvsResultDto request) {
        dvsService.verificationResultProcess(request);
        return ResponseEntity.ok().build();
    }
}
