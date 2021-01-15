package com.dw.boot.s1.config;

import com.dw.boot.s1.strategy.StudyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HandlerStudyContext {

    @Autowired
    private ApplicationContext applicationContext;
    // 存放所有策略类Bean的map
    public static Map<String, Class<StudyStrategy>> studyStrategyBeanMap = new HashMap<>();

    public StudyStrategy getStudyStrategy(String type) {
        Class<StudyStrategy> strategyClass = studyStrategyBeanMap.get(type);
        if (strategyClass == null) {
            throw new IllegalArgumentException("没有对应的学习策略");
        }
        // 从容器中获取对应的策略Bean
        return applicationContext.getBean(strategyClass);
    }

}
