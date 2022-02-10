package com.ancestors.services;

import com.ancestors.dtos.request.ParentDto;
import com.ancestors.entities.Parent;
import com.ancestors.exception.ResourceAlreadyExistsException;
import com.ancestors.exception.ResourceDoesNotExistException;

import java.util.List;

public interface ParentService {
    List<Parent> getAll();
    Parent get(long id) throws ResourceDoesNotExistException;
    Parent add(ParentDto parentDto) throws ResourceAlreadyExistsException, ResourceDoesNotExistException;
    Parent update(long id, Parent parent) throws ResourceDoesNotExistException;
    void delete(long id) throws ResourceDoesNotExistException;

}
