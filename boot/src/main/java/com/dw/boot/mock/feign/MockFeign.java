package com.dw.boot.mock.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mock", url = "http://localhost:9000", fallbackFactory = MockFeignFallbackFactory.class)
public interface MockFeign {

    @GetMapping("/mock/feign1")
    String mock1(@RequestParam String flag);

    @GetMapping("/mock/feign2")
    String mock2(@RequestParam String flag);

}
