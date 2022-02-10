package com.ancestors.controllers.impl;

import com.ancestors.controllers.ChildController;
import com.ancestors.dtos.request.ChildDto;
import com.ancestors.entities.Child;
import com.ancestors.exception.ResourceAlreadyExistsException;
import com.ancestors.exception.ResourceDoesNotExistException;
import com.ancestors.services.ChildService;
import com.ancestors.services.ParentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ChildControllerImpl implements ChildController {

    @Autowired
    private ChildService childService;

    @Autowired
    private ParentService parentService;

    @Override
    public ResponseEntity<Void> add(ChildDto childDto) {
        try {
            Child child = new Child();
            BeanUtils.copyProperties(childDto,child);
            child.setFather(parentService.get(childDto.getFathersId()));
            child.setMother(parentService.get(childDto.getMothersId()));
            Child savedChild = childService.add(child);
        } catch (ResourceAlreadyExistsException | ResourceDoesNotExistException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Child> get(String id) {
        try {
            Child savedChild = childService.get(Long.parseLong(id));
            return ResponseEntity.ok().body(savedChild);
        } catch (ResourceDoesNotExistException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResponseEntity<Child> update(String id, Child child) {
        try {
            Child updatedChild = childService.update(Long.parseLong(id), child);
            return ResponseEntity.status(HttpStatus.OK).body(updatedChild);
        } catch (ResourceDoesNotExistException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        try {
            if(childService.delete(Long.parseLong(id))){
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        } catch (ResourceDoesNotExistException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }
}
