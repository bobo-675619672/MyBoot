package com.dw.boot.s1.service;

import java.util.Map;

public interface StudyService {

    void start(String type, Map<String, Object> request);

    void publishQuestions(String type, Map<String, Object> request);

}
