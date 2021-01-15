package com.dw.boot.s2.controller;

import com.dw.boot.s2.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController("S2")
@RequestMapping("/s2/{type}")
public class StudyController {

    @Resource(name = "ipaService")
    private StudyService studyService;

    @PostMapping("/publishQuestions")
    public void publishQuestions(@RequestBody Map<String, Object> request) {
        studyService.publishQuestions(request);
    }

}
