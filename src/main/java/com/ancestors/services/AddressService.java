package com.ancestors.services;

import com.ancestors.dtos.request.ParentDto;
import com.ancestors.entities.Address;
import com.ancestors.entities.Parent;
import com.ancestors.exception.ResourceAlreadyExistsException;
import com.ancestors.exception.ResourceDoesNotExistException;

import java.util.List;

public interface AddressService {
    Address getAddressByZip(String zip) throws ResourceDoesNotExistException;
    List<Address> getAll();
    Address get(long id) throws ResourceDoesNotExistException;
    Address add(Address address) throws ResourceAlreadyExistsException, ResourceDoesNotExistException;
    Address update(long id, Address address) throws ResourceDoesNotExistException;
    boolean delete(long id) throws ResourceDoesNotExistException;
}
