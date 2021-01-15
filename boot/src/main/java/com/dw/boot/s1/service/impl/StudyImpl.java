package com.dw.boot.s1.service.impl;

import com.dw.boot.s1.config.HandlerStudyContext;
import com.dw.boot.s1.service.StudyService;
import com.dw.boot.s1.strategy.StudyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudyImpl implements StudyService {

    @Autowired
    private HandlerStudyContext handlerStudyContext;

    @Override
    public void start(String type, Map<String, Object> request) {
        System.out.println("开始作业公共逻辑!");
        StudyStrategy studyStrategy = handlerStudyContext.getStudyStrategy(type);
        studyStrategy.start(request);
    }

    @Override
    public void publishQuestions(String type, Map<String, Object> request) {
        System.out.println("提交作业小题公共逻辑!");
        System.out.println("公共逻辑:保存日志...");
        StudyStrategy studyStrategy = handlerStudyContext.getStudyStrategy(type);
        studyStrategy.publishQuestions(request);
    }

}
