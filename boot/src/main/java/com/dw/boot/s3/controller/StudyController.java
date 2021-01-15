package com.dw.boot.s3.controller;

import com.dw.boot.s3.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("S3")
@RequestMapping("/s3")
public class StudyController {

    @Autowired
    private StudyService studyService;

    @PostMapping("/study/{type}")
    public void study(@PathVariable String type, @RequestBody Map<String, Object> request) {
        studyService.study(type, request);
    }

}
