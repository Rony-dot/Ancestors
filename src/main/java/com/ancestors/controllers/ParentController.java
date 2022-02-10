package com.ancestors.controllers;

import com.ancestors.dtos.request.ParentDto;
import com.ancestors.entities.Parent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/parents")
public interface ParentController {

    @PostMapping("/add")
    ResponseEntity<Void> add(@RequestBody Parent parent);

    @GetMapping("/{id}")
    ResponseEntity<Parent> get(@PathVariable String id);

    @PutMapping("/{id}")
    ResponseEntity<Parent> update(@PathVariable String id, @RequestBody Parent parent);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable String id);
}
