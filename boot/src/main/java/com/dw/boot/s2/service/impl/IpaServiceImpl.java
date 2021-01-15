package com.dw.boot.s2.service.impl;

import com.dw.boot.s2.service.StudyService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("ipaService")
public class IpaServiceImpl implements StudyService {

    @Override
    public void publishQuestions(Map<String, Object> request) {
        System.out.println("保存ipa小题");
    }

}
