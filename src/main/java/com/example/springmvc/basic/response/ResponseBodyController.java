package com.example.springmvc.basic.response;

import com.example.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    /*
     * HttpEntity, ResponseEntity(Http Status 추가)
     * @return
     */
    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping("/response-body-string-v3")
    public String responseBody3() {
        return "ok";
    }

    @GetMapping("/response-body-string-v4")
    public ResponseEntity<HelloData> responseBodyV4() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(23);
        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/response-body-string-v5")
    public HelloData responseBodyV5() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(23);
        return helloData;
    }
}
