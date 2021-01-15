package com.dw.boot.s3.factory;

import com.dw.boot.s3.handler.StudyHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StudyHandlerFactory implements InitializingBean, ApplicationContextAware {

    private static final Map<String, StudyHandler> STUDY_HANDLER_MAP = new HashMap<>(3);

    private ApplicationContext appContext;

    public StudyHandler getHandler(String studyType) {
        return STUDY_HANDLER_MAP.get(studyType);
    }

    @Override
    public void afterPropertiesSet() {
        appContext.getBeansOfType(StudyHandler.class).values().forEach(handler -> STUDY_HANDLER_MAP.put(handler.getStudyType(), handler));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }

}
