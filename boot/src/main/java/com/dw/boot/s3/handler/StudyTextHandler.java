package com.dw.boot.s3.handler;

import com.dw.boot.s3.constant.StudyConstant;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StudyTextHandler implements StudyHandler {

    @Override
    public String getStudyType() {
        return StudyConstant.TEXT;
    }

    @Override
    public String study(Map<String, Object> request) {
        return "学习课文text!";
    }

}
