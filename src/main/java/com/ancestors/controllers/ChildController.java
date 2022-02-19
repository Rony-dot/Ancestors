package com.ancestors.controllers;


import com.ancestors.dtos.request.ChildDto;
import com.ancestors.entities.Child;
import com.ancestors.entities.Parent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/childs")
public interface ChildController {

    @GetMapping("")
    public ResponseEntity<List<Child>> getAll();

    @PostMapping("/add")
    ResponseEntity<Void> add(@RequestBody ChildDto childDto);

    @GetMapping("/{id}")
    ResponseEntity<Child> get(@PathVariable String id);

    @PutMapping("/{id}")
    ResponseEntity<Child> update(@PathVariable String id, @RequestBody Child child);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable String id);
}
