package com.ancestors.services.impl;

import com.ancestors.entities.Address;
import com.ancestors.entities.Child;
import com.ancestors.exception.ResourceAlreadyExistsException;
import com.ancestors.exception.ResourceDoesNotExistException;
import com.ancestors.repositories.AddressRepository;
import com.ancestors.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address getAddressByZip(String zip) throws ResourceDoesNotExistException {
        Optional<Address> addressByZip = addressRepository.findAddressByZip(zip);
        if(addressByZip.isPresent()){
            return addressByZip.get();
        }else {
            throw new ResourceDoesNotExistException(zip+"");
        }
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address get(long id) throws ResourceDoesNotExistException {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if(optionalAddress.isPresent()){
            return optionalAddress.get();
        }else{
            throw new ResourceDoesNotExistException(id+"");
        }
    }

    @Override
    public Address add(Address address) throws ResourceAlreadyExistsException, ResourceDoesNotExistException {
        Address savedAddress = addressRepository.save(address);
        return savedAddress;
    }

    @Override
    public Address update(long id, Address address) throws ResourceDoesNotExistException {
        return null;
    }

    @Override
    public void delete(long id) throws ResourceDoesNotExistException {

    }


}
