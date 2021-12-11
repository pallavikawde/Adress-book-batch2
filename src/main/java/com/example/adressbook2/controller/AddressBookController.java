package com.example.adressbook2.controller;

import com.example.adressbook2.entity.AddressBookEntity;
import com.example.adressbook2.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/AddressBook")
public class AddressBookController {
    @Autowired
    private AddressBookService addressBookService;

    @GetMapping("/list-of-all-books")
    public List<AddressBookEntity>etListOfAddressBook(){
        return addressBookService.getAllList();

    }
}
