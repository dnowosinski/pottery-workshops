package com.pottery_workshops.pottery_workshops.controller;

import com.pottery_workshops.pottery_workshops.service.ClassEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/classEntity")
public class ClassEntityController {
    @Autowired
    private ClassEntityService classEntityService;

//    @GetMapping
//    @PostMapping
}
