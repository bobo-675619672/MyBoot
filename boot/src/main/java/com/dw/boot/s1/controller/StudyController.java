package com.dw.boot.s1.controller;

import com.dw.boot.s1.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("S1")
@RequestMapping("/s1/{type}")
public class StudyController {

    @Autowired
    private StudyService studyService;

    @PostMapping("/start")
    public void handleOrder(@PathVariable String type, @RequestBody Map<String, Object> request) {
        studyService.start(type, request);
    }

    @PostMapping("/publishQuestions")
    public void publishQuestions(@PathVariable String type, @RequestBody Map<String, Object> request) {
        studyService.publishQuestions(type, request);
    }

}
