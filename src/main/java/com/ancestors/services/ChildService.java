package com.ancestors.services;

import com.ancestors.entities.Child;
import com.ancestors.entities.Parent;
import com.ancestors.exception.ResourceAlreadyExistsException;
import com.ancestors.exception.ResourceDoesNotExistException;

import java.util.List;

public interface ChildService {
    List<Child> getAll();
    Child get(long id) throws ResourceDoesNotExistException;
    Child add(Child child) throws ResourceAlreadyExistsException;
    Child update(long id, Child hild) throws ResourceDoesNotExistException;
    boolean delete(long id) throws ResourceDoesNotExistException;
}
