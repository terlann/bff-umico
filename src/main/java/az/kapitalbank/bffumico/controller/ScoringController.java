package az.kapitalbank.bffumico.controller;

import az.kapitalbank.bffumico.dto.request.ScoringOrderRequestDto;
import az.kapitalbank.bffumico.service.ScoringService;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/marketplace/scoring")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ScoringController {

    ScoringService service;

    @PostMapping
    @ApiOperation(value = "telesales result", hidden = true)
    public ResponseEntity<Void> telesalesResult(@RequestBody ScoringOrderRequestDto request) {
        return service.telesalesResult(request);
    }

}
