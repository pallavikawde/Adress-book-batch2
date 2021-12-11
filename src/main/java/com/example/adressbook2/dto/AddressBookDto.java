package com.example.adressbook2.dto;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class AddressBookDto {
    private String name;
    private String address;
    private String city;
    private String state;
    private String phoneNumber;
    private int zip;
//    @CreationTimestamp
//    private LocalDateTime createdOn;

}
