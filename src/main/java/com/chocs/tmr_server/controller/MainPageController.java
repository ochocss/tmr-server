package com.chocs.tmr_server.controller;

import com.chocs.tmr_server.domain.Task;
import com.chocs.tmr_server.service.MainPageService;
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

    @DeleteMapping("")
    public void delete(@PathVariable("id") int id) {
        mainPageService.delete(id);
    }
}