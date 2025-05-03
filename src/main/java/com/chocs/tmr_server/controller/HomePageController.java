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

    @GetMapping("/home")
    public List<Task> get() {
        return homePageService.get();
    }

    @DeleteMapping("/home/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        return homePageService.delete(id);
    }
}