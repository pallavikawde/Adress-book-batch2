package com.example.adressbook2.service;

import com.example.adressbook2.dto.AddressBookDto;
import com.example.adressbook2.entity.AddressBookEntity;
//import com.example.adressbook2.exception.AddressBookNotFound;
import com.example.adressbook2.exception.EmptyInputException;
import com.example.adressbook2.repository.AddressBookRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressBookService {

    private static final String ID_DELETED_SUCCESSFULLY = "ID-DELETED-SUCCESSFULLY";
    private static final String DETAIL_ADDED_SUCCESSFULLY = "DETAIL_ADDED_SUCCESSFULLY";
    private static final String UPDATED_SUCCESSFULLY = "UPDATED_SUCCESSFULLY";

    @Autowired
    private AddressBookRepo addressBookRepository;


    @Autowired
    private ModelMapper mapper;

        public String addDetails(AddressBookDto addressBookDto){
            if(addressBookDto.getName().isEmpty()||addressBookDto.getName().length()==0){
                throw new EmptyInputException("601","please check");

            }
        AddressBookEntity addressBookEntity = mapper.map(addressBookDto,AddressBookEntity.class);
         addressBookRepository.save(addressBookEntity);
            return DETAIL_ADDED_SUCCESSFULLY;
        }

        public String deletAddressBookId(int id) {
        addressBookRepository.deleteById(id);
        return ID_DELETED_SUCCESSFULLY;
    }

        public List<AddressBookDto> getAllList() {
           return addressBookRepository.findAll().stream().map(addressBookEntity -> mapper.map(addressBookEntity,AddressBookDto.class)).collect(Collectors.toList());
    }

    public String updateList(int id, AddressBookDto addressBookDto) {
        AddressBookEntity addressBookEntity = checkIdPresentOrNot(id);
        mapper.map(addressBookDto,addressBookEntity);
        //addressBookRepository.findById(id);
        addressBookRepository.save(addressBookEntity);
        return UPDATED_SUCCESSFULLY;

    }
    public AddressBookEntity checkIdPresentOrNot(int empId) {
        return addressBookRepository.findById(empId).get();
    }

    public AddressBookEntity getAddressByBookId(int id) {
            return addressBookRepository.findById(id).get();
    }
}

