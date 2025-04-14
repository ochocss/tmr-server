package com.chocs.tmr_server.controller;

import com.chocs.tmr_server.service.CreatePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CreatePageController {
    @Autowired
    CreatePageService createPageService;

    @GetMapping("/create")
    public List<String> get() {
        return createPageService.get();
    }
}
