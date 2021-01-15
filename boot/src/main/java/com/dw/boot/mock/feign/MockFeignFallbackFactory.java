package com.dw.boot.mock.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MockFeignFallbackFactory implements FallbackFactory<MockFeign> {

    @Override
    public MockFeign create(Throwable throwable) {
        return null;
    }

}
