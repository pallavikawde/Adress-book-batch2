package com.example.adressbook2.repository;

import com.example.adressbook2.dto.AddressBookDto;
import com.example.adressbook2.entity.AddressBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepo extends JpaRepository<AddressBookEntity,Integer> {
}
