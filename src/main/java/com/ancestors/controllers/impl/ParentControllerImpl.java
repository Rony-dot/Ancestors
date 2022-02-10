package com.ancestors.controllers.impl;

import com.ancestors.controllers.ParentController;
import com.ancestors.dtos.request.ParentDto;
import com.ancestors.entities.Child;
import com.ancestors.entities.Parent;
import com.ancestors.exception.ResourceAlreadyExistsException;
import com.ancestors.exception.ResourceDoesNotExistException;
import com.ancestors.services.ParentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ParentControllerImpl implements ParentController {

    @Autowired
    private ParentService parentService;

    @Override
    public ResponseEntity<Parent> add(ParentDto parentDto) {
        try {
            Parent savedParent = parentService.add(parentDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedParent);
        } catch (ResourceAlreadyExistsException | ResourceDoesNotExistException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Parent> get(String id) {
        try {
            Parent savedParent = parentService.get(Long.parseLong(id));
            return ResponseEntity.ok().body(savedParent);
        } catch (ResourceDoesNotExistException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Parent> update(String id, Parent parent) {
        try {
            Parent updatedParent = parentService.update(Long.parseLong(id), parent);
            return ResponseEntity.status(HttpStatus.OK).body(updatedParent);
        } catch (ResourceDoesNotExistException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        try {
            if(parentService.delete(Long.parseLong(id))){
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        } catch (ResourceDoesNotExistException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }
}
