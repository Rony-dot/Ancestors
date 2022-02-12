package com.ancestors.services;

import com.ancestors.entities.Address;
import com.ancestors.exception.ResourceAlreadyExistsException;
import com.ancestors.exception.ResourceDoesNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.validation.Validator;
import java.time.LocalDateTime;

@SpringBootTest
public class AddressServiceTests {
//
//    Address address;
//
//    @Autowired
//    AddressService addressService;
//
//    @Autowired
//    Validator validator;
//
//
//    @BeforeEach
//    public void init() {
//        this.address = new Address(12, LocalDateTime.now(),LocalDateTime.now(),"wall Street 1", "New York", "New York", "10001");
//        validator.validate(this.address);
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
//
//    @Test
//    void testCreateAddress(){
//        try {
//            Address savedAddress = addressService.add(this.address);
//            System.out.println(address.toString());
//            Address addressByZip = addressService.getAddressByZip(savedAddress.getZip());
//            Assertions.assertEquals(this.address.getZip(), savedAddress.getZip());
//        } catch (ResourceAlreadyExistsException e) {
//            e.printStackTrace();
//        } catch (ResourceDoesNotExistException e) {
//            e.printStackTrace();
//        }
//    }


}
