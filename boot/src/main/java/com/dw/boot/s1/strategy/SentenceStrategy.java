package com.dw.boot.s1.strategy;

import com.dw.boot.s1.annotation.HandlerStudyType;
import com.dw.boot.s1.constant.StudyConstant;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@HandlerStudyType(StudyConstant.SENTENCE)
public class SentenceStrategy implements StudyStrategy {

    @Override
    public void start(Map<String, Object> request) {
        System.out.println("处理sentence逻辑!");
    }

    @Override
    public void publishQuestions(Map<String, Object> request) {
        System.out.println("sentence提交小题逻辑!");
    }

}
