package com.dw.boot.s1.strategy;

import java.util.Map;

public interface StudyStrategy {

    void start(Map<String, Object> request);

    void publishQuestions(Map<String, Object> request);

}
