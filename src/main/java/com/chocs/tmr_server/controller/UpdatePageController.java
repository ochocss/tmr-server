package com.chocs.tmr_server.controller;

import com.chocs.tmr_server.domain.Task;
import com.chocs.tmr_server.service.UpdatePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UpdatePageController {
    @Autowired
    UpdatePageService updatePageService;

    @PutMapping(value="/edit/{id}", consumes={"application/json"})
    public ResponseEntity<Void> put(@PathVariable int id, @RequestBody Task task) {
        if (updatePageService.put(task)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
