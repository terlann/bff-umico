package az.kapitalbank.bffumico.controller;

import az.kapitalbank.bffumico.dto.request.ImeiCodeRequestDto;
import az.kapitalbank.bffumico.service.ImeiService;
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/imei")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ImeiController {

    ImeiService imeiService;

    public ResponseEntity<Void> saveImeiCode(
            @Valid @RequestBody ImeiCodeRequestDto imeiCodeRequestDto) {
        imeiService.saveImei(imeiCodeRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
