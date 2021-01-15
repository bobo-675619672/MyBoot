package com.dw.boot.mock.service.impl;

import com.dw.boot.mock.feign.MockFeign;
import com.dw.boot.mock.service.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MockServiceImpl implements MockService {

    @Autowired
    private MockFeign mockFeign;

    @Override
    public String mock1(String flag) {
        return mockFeign.mock1(flag);
    }

    @Override
    public String mock2(String flag) {
        return mockFeign.mock2(flag);
    }

}
