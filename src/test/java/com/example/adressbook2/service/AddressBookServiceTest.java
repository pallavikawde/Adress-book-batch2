package com.example.adressbook2.service;

import com.example.adressbook2.controller.AddressBookController;
import com.example.adressbook2.dto.AddressBookDto;
import com.example.adressbook2.entity.AddressBookEntity;
import com.example.adressbook2.repository.AddressBookRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressBookServiceTest {
    @Mock
    private AddressBookRepo addressBookRepo;

    @InjectMocks
    private AddressBookService addressBookService;
    @Mock
    private ModelMapper mapper;

    AddressBookDto addressBookDto1;
    AddressBookDto addressBookDto2;
    AddressBookEntity addressBookEntity;
    AddressBookEntity addressBookEntity1;

    @BeforeEach
    void setUp(){
        addressBookDto2 = new AddressBookDto();
        addressBookDto2.setAddress("begampura");
        addressBookDto2.setCity("aurangabad");
        addressBookDto2.setFirstName("pallavi");
        addressBookDto2.setPhoneNumber("91-23456");
        addressBookDto2.setLastName("jagtap");
        addressBookDto2.setZipCode("2345");
        addressBookDto2.setState("maharshtra");

        addressBookDto1 = new AddressBookDto();
        addressBookDto1.setAddress("begampura");
        addressBookDto1.setCity("aurangabad");
        addressBookDto1.setFirstName("pallavi");
        addressBookDto1.setPhoneNumber("91-23456");
        addressBookDto1.setLastName("jagtap");
        addressBookDto1.setZipCode("2345");
        addressBookDto1.setState("maharshtra");

        addressBookEntity = new AddressBookEntity();
        addressBookEntity.setAddress("begampura");
        addressBookEntity.setCity("aurangabad");
        addressBookEntity.setFirstName("pallavi");
        addressBookEntity.setPhoneNumber("91-23456");
        addressBookEntity.setLastName("jagtap");
        addressBookEntity.setZipCode("2345");
        addressBookEntity.setState("maharshtra");


        addressBookEntity1= new AddressBookEntity();
        addressBookEntity1.setAddress("begampura");
        addressBookEntity1.setCity("aurangabad");
        addressBookEntity1.setFirstName("pallavi");
        addressBookEntity1.setPhoneNumber("91-23456");
        addressBookEntity1.setLastName("jagtap");
        addressBookEntity1.setZipCode("2345");
        addressBookEntity1.setState("maharshtra");

    }
    @Test
    void whenGetAllAddressBookCalled_shouldReturnListOfEmpDto() {
        when(addressBookRepo.findAll()).thenReturn(List.of(addressBookEntity));
        Assertions.assertEquals(List.of(addressBookEntity),addressBookRepo.findAll());
    }
    @Test
    void whenAddAddressBookDetailsCalled_shouldReturnGenerateSuccessMessage() {
        String successMessage = "DETAIL_ADDED_SUCCESSFULLY";
        when(mapper.map(addressBookDto1,AddressBookEntity.class)).thenReturn(addressBookEntity);
        // when(employeePayrollRepository.save(employeePayrollModel)).thenReturn(successMessage);
        String actualMessage = addressBookService.addDetails(addressBookDto1);
        Assertions.assertEquals(successMessage,actualMessage);

}
    @Test
    void whenAddressBookIdDeleted_shouldReturnSuccessMessage() {
        String successMessage = "ID-DELETED-SUCCESSFULLY";
        int id = 1;
       lenient().when(addressBookRepo.findById(id)).thenReturn(Optional.of(addressBookEntity));
        String actualMessage = addressBookService.deletAddressBookId(id);
        Assertions.assertEquals(successMessage, actualMessage);
        //  verify(employeePayrollRepository, times(1)).delete(employeePayrollModel);
    }
    @Test
    void whenAddressBookIdUpdated_shouldReturnSuccessMessage() {
        String successMessage = "id updated successfully";
        int id = 2;
        when(addressBookRepo.findById(id)).thenReturn(Optional.of(addressBookEntity));
        when(mapper.map(addressBookDto1,AddressBookEntity.class)).thenReturn(addressBookEntity);
        String actualMessage = addressBookService.updateList(addressBookDto1,id);
        assertEquals(successMessage, actualMessage);
    }



}
