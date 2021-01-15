package com.dw.boot.s1.strategy;

import com.dw.boot.s1.annotation.HandlerStudyType;
import com.dw.boot.s1.constant.StudyConstant;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@HandlerStudyType(StudyConstant.IPA)
public class IpaStrategy implements StudyStrategy {

    @Override
    public void start(Map<String, Object> request) {
        System.out.println("处理ipa逻辑!");
    }

    @Override
    public void publishQuestions(Map<String, Object> request) {
        System.out.println("ipa提交小题逻辑!");
    }

}
