package com.ancestors.services.impl;

import com.ancestors.entities.Parent;
import com.ancestors.exception.ResourceAlreadyExistsException;
import com.ancestors.exception.ResourceDoesNotExistException;
import com.ancestors.repositories.ParentRepository;
import com.ancestors.services.ParentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    private ParentRepository parentRepository;

    @Override
    public List<Parent> getAll() {
        List<Parent> allParents = parentRepository.findAll();
        return allParents;
    }

    @Override
    public Parent get(long id) throws ResourceDoesNotExistException {
        Optional<Parent> optionalParent = parentRepository.findById(id);
        if(optionalParent.isPresent()){
            return optionalParent.get();
        }else{
            throw new ResourceDoesNotExistException(id+"");
        }
    }

    @Override
    public Parent add(Parent parent) throws ResourceAlreadyExistsException {
        Optional<Parent> optionalParent = parentRepository.findById(parent.getId());
        if(!optionalParent.isPresent()){
            Parent savedParent = parentRepository.save(parent);
            return savedParent;
        }else{
            throw new ResourceAlreadyExistsException(parent.getId()+"");
        }
    }

    @Override
    public Parent update(long id, Parent parent) throws ResourceDoesNotExistException {
        Optional<Parent> optionalParent = parentRepository.findById(parent.getId());
        if(optionalParent.isPresent()){
            parent.setId(id);
            Parent savedParent = parentRepository.save(parent);
            return savedParent;
        }else{
            throw new ResourceDoesNotExistException(parent.getId()+"");
        }
    }

    @Override
    public void delete(long id) throws ResourceDoesNotExistException {
        Optional<Parent> optionalParent = parentRepository.findById(id);
        if(optionalParent.isPresent()){
           parentRepository.deleteById(id);
        }else{
            throw new ResourceDoesNotExistException(id+"");
        }
    }
}
