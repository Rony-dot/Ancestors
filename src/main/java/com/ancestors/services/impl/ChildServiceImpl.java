package com.ancestors.services.impl;

import com.ancestors.entities.Child;
import com.ancestors.entities.Child;
import com.ancestors.exception.ResourceAlreadyExistsException;
import com.ancestors.exception.ResourceDoesNotExistException;
import com.ancestors.repositories.ChildRepository;
import com.ancestors.services.ChildService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    private ChildRepository childRepository;

    @Override
    public List<Child> getAll() {
        List<Child> allChild = childRepository.findAll();
        return allChild;
    }

    @Override
    public Child get(long id) throws ResourceDoesNotExistException {
        Optional<Child> optionalChild = childRepository.findById(id);
        if(optionalChild.isPresent()){
            return optionalChild.get();
        }else{
            throw new ResourceDoesNotExistException(id+"");
        }
    }

    @Override
    public Child add(Child child) throws ResourceAlreadyExistsException {
        Optional<Child> optionalChild = childRepository.findById(child.getId());
        if(!optionalChild.isPresent()){
            Child savedChild = childRepository.save(child);
            return savedChild;
        }else{
            throw new ResourceAlreadyExistsException(child.getId()+"");
        }
    }

    @Override
    public Child update(long id, Child child) throws ResourceDoesNotExistException {
        Optional<Child> optionalChild = childRepository.findById(child.getId());
        if(optionalChild.isPresent()){
            child.setId(id);
            Child savedChild = childRepository.save(child);
            return savedChild;
        }else{
            throw new ResourceDoesNotExistException(child.getId()+"");
        }
    }

    @Override
    public boolean delete(long id) throws ResourceDoesNotExistException {
        Optional<Child> optionalChild = childRepository.findById(id);
        if(optionalChild.isPresent()){
            childRepository.deleteById(id);
        }else{
            throw new ResourceDoesNotExistException(id+"");
        }
        return true;
    }
}
