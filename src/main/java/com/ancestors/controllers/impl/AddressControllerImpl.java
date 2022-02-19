package com.ancestors.controllers.impl;

import com.ancestors.controllers.AddressController;
import com.ancestors.entities.Address;
import com.ancestors.entities.Child;
import com.ancestors.exception.ResourceAlreadyExistsException;
import com.ancestors.exception.ResourceDoesNotExistException;
import com.ancestors.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AddressControllerImpl implements AddressController {
    @Autowired
    private AddressService addressService;

    @Override
    public ResponseEntity<List<Address>> getAll() {
        return ResponseEntity.ok(addressService.getAll());
    }

    @Override
    public ResponseEntity<Address> add(Address address) {
        try {
            Address savedAddress = addressService.add(address);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress);
        } catch (ResourceAlreadyExistsException | ResourceDoesNotExistException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<Address> get(String id) {
        try {
            Address address = addressService.get(Long.parseLong(id));
            return ResponseEntity.ok().body(address);
        } catch (ResourceDoesNotExistException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Address> update(String id, Address address) {
        try {
            Address updatedAddress = addressService.update(Long.parseLong(id), address);
            return ResponseEntity.status(HttpStatus.CREATED).body(updatedAddress);
        } catch (ResourceDoesNotExistException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        try {
            if(addressService.delete(Long.parseLong(id))){
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        } catch (ResourceDoesNotExistException e) {
            e.printStackTrace();

        }
        return ResponseEntity.notFound().build();
    }
}
