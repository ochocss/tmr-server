package com.chocs.tmr_server.controller;

import com.chocs.tmr_server.domain.Task;
import com.chocs.tmr_server.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class HomePageController {
    @Autowired
    HomePageService homePageService;

    @GetMapping("")
    public List<Task> get() {
        return homePageService.get();
    }

    @PostMapping
    public void post(@RequestBody Task task) {
        homePageService.post(task);
    }

    @PutMapping
    public void put(@RequestBody Task task) {
        homePageService.put(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        return homePageService.delete(id);
    }
}