package com.ancestors;

import com.ancestors.entities.Address;
import com.ancestors.entities.Child;
import com.ancestors.entities.Parent;
import com.ancestors.exception.ResourceDoesNotExistException;
import com.ancestors.services.AddressService;
import com.ancestors.services.ChildService;
import com.ancestors.services.ParentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AncestorsApplicationTests {
//
//    @Autowired
//    AddressService addressService;
//    @Autowired
//    ParentService parentService;
//    @Autowired
//    ChildService childService;
//
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    void testReadParent(){
//        try {
//            Parent parent = parentService.get(2);
//            System.out.println(parent.toString());
//        } catch (ResourceDoesNotExistException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    void testReadChild(){
//        try {
//            Child child = childService.get(4);
//            System.out.println(child.toString());
//        } catch (ResourceDoesNotExistException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    void testReadAddress(){
//        try {
//            Address address = addressService.get(1);
//            System.out.println(address.toString());
//        } catch (ResourceDoesNotExistException e) {
//            e.printStackTrace();
//        }
//    }

}
