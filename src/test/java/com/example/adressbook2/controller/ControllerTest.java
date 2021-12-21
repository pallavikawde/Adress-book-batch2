//package com.example.adressbook2.controller;
//
//import com.example.adressbook2.dto.AddressBookDto;
//import com.example.adressbook2.service.AddressBookService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class ControllerTest {
//
//    AddressBookDto addressBookDto1;
//    AddressBookDto addressBookDto2;
//    AddressBookDto addressBookDto3;
//
//    @InjectMocks
//    private AddressBookController addressBookController;
//
//    @Mock
//    private AddressBookService addressBookService;
//
//    @BeforeEach
//    void setUp(){
//        addressBookDto2 = new AddressBookDto();
//        addressBookDto2.setAddress("begampura");
//        addressBookDto2.setCity("aurangabad");
//        addressBookDto2.setFirstName("pallavi");
//        addressBookDto2.setPhoneNumber("91-23456");
//        addressBookDto2.setLastName("jagtap");
//        addressBookDto2.setZipCode("2345");
//        addressBookDto2.setState("maharshtra");
//
//        addressBookDto3 = new AddressBookDto();
//        addressBookDto3.setAddress("begampura");
//        addressBookDto3.setCity("aurangabad");
//        addressBookDto3.setFirstName("pallavi");
//        addressBookDto3.setPhoneNumber("91-23456");
//        addressBookDto3.setLastName("jagtap");
//        addressBookDto3.setZipCode("2345");
//        addressBookDto3.setState("maharshtra");
//
//        addressBookDto1 = new AddressBookDto();
//        addressBookDto1.setAddress("begampura");
//        addressBookDto1.setCity("aurangabad");
//        addressBookDto1.setFirstName("pallavi");
//        addressBookDto1.setPhoneNumber("91-23456");
//        addressBookDto1.setLastName("jagtap");
//        addressBookDto1.setZipCode("2345");
//        addressBookDto1.setState("maharshtra");
//
//    }
//
//    @Test
//    void whenGetAllListOfAddresBookCalled_shouldReturnListOfAddressBookDto() {
//        when(addressBookController.getAllListOfBokks()).thenReturn(List.of(addressBookDto1,addressBookDto2,addressBookDto3));
//        Assertions.assertEquals(List.of(addressBookDto1,addressBookDto2,addressBookDto3),addressBookController.getAllListOfBokks());
//    }
//
//    @Test
//    void whenAddAddressBookDetailsCalled_shouldReturnGenrateSuccessMessage() {
//        String SuccessMessage = "added ";
//        when(addressBookController.addDetail(addressBookDto1)).thenReturn(SuccessMessage);
//        String actualResponse = addressBookController.addDetail(addressBookDto1);
//        Assertions.assertEquals(actualResponse,SuccessMessage);
//    }
//
//    @Test
//    void whenIdDeleted_shouldReturnSuccessMessage() {
//        String SuccessMessage = "id deleted successfully";
//        int id =1;
//        when(addressBookService.deletAddressBookId(id)).thenReturn(SuccessMessage);
//        String actualResponse = addressBookController.deleteAddressBookId(id);
//        Assertions.assertEquals(SuccessMessage,actualResponse);
//    }
//
//    @Test
//    void givenAddressBookDto_whenCalledUpdatePayroll_shouldReturnSuccessMessage() {
//        String successMessage = "id updated successfully";
//        int id = 2;
//        when(addressBookService.updateList(id,addressBookDto1)).thenReturn(successMessage);
//        String actualResponse = addressBookService.updateList(id,addressBookDto1);
//        Assertions.assertEquals(actualResponse,successMessage);
//    }
//}
