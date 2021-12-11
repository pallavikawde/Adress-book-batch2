package com.example.adressbook2.service;

import com.example.adressbook2.dto.AddressBookDto;
import com.example.adressbook2.entity.AddressBookEntity;
import com.example.adressbook2.repository.AddressBookRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepo addressBookRepository;

    @Autowired
    private ModelMapper mapper;

    public List<AddressBookDto> getAllList() {
        return addressBookRepository.findAll()
                .stream()
                .map(addressBookEntity -> mapper.map(addressBookEntity, AddressBookDto.class))
                .collect(Collectors.toList());
    }
}
