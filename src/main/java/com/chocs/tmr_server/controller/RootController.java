package com.chocs.tmr_server.controller;

import com.chocs.tmr_server.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class RootController {
    @Autowired
    RootService rootService;

    @GetMapping("/subjects")
    public List<String> getSubjects() {
        return rootService.getSubjects();
    }
}
