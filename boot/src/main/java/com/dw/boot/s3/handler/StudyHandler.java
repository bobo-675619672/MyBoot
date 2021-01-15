package com.dw.boot.s3.handler;

import java.util.Map;

public interface StudyHandler {

    String getStudyType();

    String study(Map<String, Object> request);

}
