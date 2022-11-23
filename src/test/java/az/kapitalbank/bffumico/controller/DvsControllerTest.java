package az.kapitalbank.bffumico.controller;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import az.kapitalbank.bffumico.dto.request.DvsResultDto;
import az.kapitalbank.bffumico.service.DvsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("local")
@WebMvcTest(DvsController.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
class DvsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    DvsService dvsService;

    static final String BASE_URL = "/api/v1/dvs";

    @Test
    void verificationResult_ShouldReturnStatusOk() throws Exception {
        var request = DvsResultDto.builder().build();

        mockMvc.perform(post(BASE_URL + "/result")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());

        verify(dvsService).verificationResultProcess(request);
    }
}
