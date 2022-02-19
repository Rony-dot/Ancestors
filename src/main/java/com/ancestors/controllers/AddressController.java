package com.ancestors.controllers;

import com.ancestors.dtos.request.ChildDto;
import com.ancestors.entities.Address;
import com.ancestors.entities.Child;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/address")
public interface AddressController {

    @GetMapping("")
    ResponseEntity<List<Address>> getAll();

    @PostMapping("/add")
    ResponseEntity<Address> add(@Valid @RequestBody Address address);

    @GetMapping("/{id}")
    ResponseEntity<Address> get(@PathVariable String id);

    @PutMapping("/{id}")
    ResponseEntity<Address> update(@PathVariable String id, @Valid  @RequestBody Address address);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable String id);
}
