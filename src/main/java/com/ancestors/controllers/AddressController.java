package com.ancestors.controllers;

import com.ancestors.dtos.request.ChildDto;
import com.ancestors.entities.Address;
import com.ancestors.entities.Child;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/address")
public interface AddressController {

    @PostMapping("/add")
    ResponseEntity<Address> add(@RequestBody Address address);

    @GetMapping("/{id}")
    ResponseEntity<Address> get(@PathVariable String id);

    @PutMapping("/{id}")
    ResponseEntity<Address> update(@PathVariable String id, @RequestBody Address address);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable String id);
}
