package com.chocs.spring_test.controller;

import com.chocs.spring_test.domain.Task;
import com.chocs.spring_test.service.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MainPageController {
    @Autowired
    MainPageService mainPageService;

    @GetMapping("")
    public List<Task> get() {
        return mainPageService.get();
    }
}