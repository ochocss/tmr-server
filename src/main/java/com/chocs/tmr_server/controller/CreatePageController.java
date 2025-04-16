package com.chocs.tmr_server.controller;

import com.chocs.tmr_server.domain.Task;
import com.chocs.tmr_server.service.CreatePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value="/create", consumes={"application/json"})
    public ResponseEntity<Void> post(@RequestBody Task task) {
        if (createPageService.post(task)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
