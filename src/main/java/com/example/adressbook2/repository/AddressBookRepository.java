package com.example.adressbook2.repository;

import com.example.adressbook2.entity.AddressBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookEntity,Integer> {
}
