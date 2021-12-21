package com.example.adressbook2.integration;

import com.example.adressbook2.controller.AddressBookController;
import com.example.adressbook2.dto.AddressBookDto;
import com.example.adressbook2.service.AddressBookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.swing.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AddressBookController.class)
//@ActiveProfile("test")
public class AddressBookIntegration {

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressBookService addressBookService;

    AddressBookDto addressBookDto1;
    AddressBookDto addressBookDto2;

    @BeforeEach
    void setUp() {
        addressBookDto1 = new AddressBookDto();
        addressBookDto1.setAddress("nasik");
        addressBookDto1.setCity("nasik");
        addressBookDto1.setFirstName("pallavi");;
        addressBookDto1.setZipCode("123");
        addressBookDto1.setState("maharashtra");
        addressBookDto1.setPhoneNumber("91 - 234567");
        addressBookDto2 = new AddressBookDto();
        addressBookDto2.setAddress("begampura");
        addressBookDto2.setCity("aurangabad");
        addressBookDto2.setFirstName("pallavi");
        addressBookDto2.setPhoneNumber("91-23456");
        addressBookDto2.setLastName("jagtap");
        addressBookDto2.setZipCode("2345");
        addressBookDto2.setState("maharshtra");



    }

    @Test
    void getAllAddressBookDetailsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/AddressBook/listOf-all-books"))
                .andExpect(status().isOk());

    }

    @Test
    void addAddressBookDetails() throws Exception {
        String dto = objectMapper.writeValueAsString(addressBookDto2);
        //when(employeePayrollService.addDetails(any())).thenReturn("Success");
        mockMvc.perform(MockMvcRequestBuilders
                .post("/AddressBook/add-detail")
                .content(dto)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();

    }

    @Test
    void updateAddressBookDetails() throws Exception {
        String dto = objectMapper.writeValueAsString(addressBookDto1);
        //when(employeePayrollService.addDetails(any())).thenReturn("Success");
        mockMvc.perform(MockMvcRequestBuilders
                .put("/AddressBook/edit-list/4")
                .content(dto)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();

    }

    @Test
    void deleteAddressBookDetails() throws Exception {
        String dto = objectMapper.writeValueAsString(addressBookDto1);
        //when(employeePayrollService.addDetails(any())).thenReturn("Success");
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/AddressBook/delete/4")
                .content(dto)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();


    }
}