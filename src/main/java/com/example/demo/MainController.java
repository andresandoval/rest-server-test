package com.example.demo;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@RestController
public class MainController {

    private final UUID ownerId = UUID.fromString("f42ddbfe-120f-4388-ae2c-90ac1a200fba");
    private final UUID subjectId = UUID.fromString("8640674a-e7da-4004-93b2-365dec2832ec");

    public static Resource getTestFile() throws IOException {
        return new FileSystemResource(
                new File("C:\\Users\\Safike\\Git\\safike-catalog\\src\\main\\resources\\pdf.pdf"));
    }

    @GetMapping("upload")
    public void upload() throws Exception {

        final FilePostDTO postDTO =
                new FilePostDTO(ownerId, "file 1", "desc 1", subjectId, "es", null, LocalDate.now().minusMonths(1));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", getTestFile());
        body.add("postDTO", postDTO);

        HttpEntity<MultiValueMap<String, Object>> requestEntityd = new HttpEntity<>(body, headers);


        final RestTemplate restTemplate = new RestTemplate();

        final Map<String, UUID> pathVariables = Collections.singletonMap("ownerId", ownerId);

        final ResponseEntity<?> iry =
                restTemplate.postForEntity("http://localhost:9000/{ownerId}/resources", requestEntityd, Object.class,
                        pathVariables);


    }


}
