package com.ancestors.controllers;

import com.ancestors.entities.Child;
import com.ancestors.services.ChildService;
import com.ancestors.services.ParentService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("")
public class FilterController {

    @Autowired
    private ChildService childService;

    @Autowired
    private ParentService parentService;

    @GetMapping("/childs/filter1")
    public MappingJacksonValue filter1(){
        List<Child> childList = childService.getAll();
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","firstName","lastName");
        FilterProvider filters = new SimpleFilterProvider().addFilter("ChlidsFilter",filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(childList);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/childs/filter2")
    public MappingJacksonValue filter2(){
        List<Child> childList = childService.getAll();
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName","lastName","id","father","mother");
        FilterProvider filters = new SimpleFilterProvider().addFilter("ChlidsFilter",filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(childList);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }


}
