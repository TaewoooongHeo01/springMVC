package com.example.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogtestController {

    @GetMapping("/log-test")
    public String logTest() {

        String name = "Spring";
        log.info("info={}", name);
        log.warn("warn={}", name);
        log.error("error={}", name);

        return "ok";
    }
}
