package com.dw.boot.mock.controller;

import com.dw.boot.mock.service.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mock")
public class MockController {

    @Autowired
    private MockService mockService;

    @GetMapping("/feign1")
    public String feign1(@RequestParam String flag) {
        return "真正调用feign1!flag:" + flag;
    }

    @GetMapping("/feign2")
    public String feign2(@RequestParam String flag) {
        return "真正调用feign2!flag:" + flag;
    }

    @GetMapping("/feign/test1")
    public String feignTest1(@RequestParam String flag) {
        return mockService.mock1(flag);
    }

    @GetMapping("/feign/test2")
    public String feignTest2(@RequestParam String flag) {
        return mockService.mock2(flag);
    }

}
