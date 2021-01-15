package com.dw.boot.s3.service;

import java.util.Map;

public interface StudyService {

    String study(String studyType, Map<String, Object> request);

}
