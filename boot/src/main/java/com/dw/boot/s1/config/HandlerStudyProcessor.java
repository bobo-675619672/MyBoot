package com.dw.boot.s1.config;

import com.dw.boot.s1.annotation.HandlerStudyType;
import com.dw.boot.s1.strategy.StudyStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 策略核心功能,获取所有策略注解的类型
 * 并将对应的class初始化到HandlerStudyContext中
 */
@Component
public class HandlerStudyProcessor implements ApplicationContextAware {

    /**
     * 获取所有的策略Beanclass 加入HandlerStudyContext属性中
     *
     * @param applicationContext
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        // 获取所有策略注解的Bean
        Map<String, Object> orderStrategyMap = applicationContext.getBeansWithAnnotation(HandlerStudyType.class);
        orderStrategyMap.forEach((k, v) -> {
            Class<StudyStrategy> orderStrategyClass = (Class<StudyStrategy>) v.getClass();
            String value = orderStrategyClass.getAnnotation(HandlerStudyType.class).value();
            // 将class加入map中,type作为key
            HandlerStudyContext.studyStrategyBeanMap.put(value, orderStrategyClass);
        });
    }

}
