package az.kapitalbank.bffumico.controller;

import az.kapitalbank.bffumico.dto.request.ScoringOrderRequestDto;
import az.kapitalbank.bffumico.service.ScoringService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/marketplace/scoring")
@ApiIgnore
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ScoringController {

    ScoringService service;

    @PostMapping
    public ResponseEntity<Void> scoreOrder(@RequestBody ScoringOrderRequestDto request) {
        return service.scoringOrder(request);
    }

}
