package com.dw.boot.s3.service.impl;

import com.dw.boot.s3.factory.StudyHandlerFactory;
import com.dw.boot.s3.handler.StudyHandler;
import com.dw.boot.s3.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudyServiceImpl implements StudyService {

    @Autowired
    private StudyHandlerFactory studyHandlerFactory;

    @Override
    public String study(String studyType, Map<String, Object> request) {
        StudyHandler studyHandler = studyHandlerFactory.getHandler(studyType);
        if (null == studyHandler) {
            return "学习类型错误!";
        }
        return studyHandler.study(request);
    }

}
