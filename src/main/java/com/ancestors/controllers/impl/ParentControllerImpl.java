package com.ancestors.controllers.impl;

import com.ancestors.controllers.ParentController;
import com.ancestors.entities.Parent;
import com.ancestors.exception.ResourceAlreadyExistsException;
import com.ancestors.exception.ResourceDoesNotExistException;
import com.ancestors.services.ParentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ParentControllerImpl implements ParentController {

    @Autowired
    private ParentService parentService;

    @Override
    public ResponseEntity<Void> add(Parent parent) {
        try {
            Parent savedParent = parentService.add(parent);
        } catch (ResourceAlreadyExistsException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Parent> get(String id) {
        try {
            Parent savedParent = parentService.get(Long.parseLong(id));
            return ResponseEntity.ok().body(savedParent);
        } catch (ResourceDoesNotExistException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResponseEntity<Parent> update(String id, Parent parent) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        return null;
    }
}
