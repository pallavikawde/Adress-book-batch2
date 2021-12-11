package com.example.adressbook2.service;

import com.example.adressbook2.entity.AddressBookEntity;
import com.example.adressbook2.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService {
@Autowired
     private AddressBookRepository addressBookRepository;

    public List<AddressBookEntity> getAllList() {
     return addressBookRepository.findAll();
    }
}
