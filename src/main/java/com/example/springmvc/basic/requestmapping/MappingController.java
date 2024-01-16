package com.example.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {

    // HTTP 메서드 모두 허용 GET, HEAD, POST, PUT, PATCH, DELETE
    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mapping get v1");
        return "ok";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping get v2");
        return "ok";
    }

    @GetMapping("/mapping/{userId}/order/{orderId}")
    public String mappingPath(@PathVariable("userId") String data, @PathVariable("orderId") String orderId) {
        log.info("mappingPath, userId={}, orderId={}", data, orderId);
        return "ok";
    }

    @GetMapping(value = "/mapping-param", params = "hi=good")
    public String mappingParam() {
        log.info("mapping param");
        return "ok";
    }

    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mapping header");
        return "ok";
    }

    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsume() {
        log.info("mappingConsumes");
        return "ok";
    }

    @PostMapping(value = "/mapping-produces", produces = "text/plain")
    public String mappingProduces() {
        log.info("mapping produces");
        return "ok";
    }
}
