package com.example.adressbook2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name ="AddressBook")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private int id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "ZIP_CODE")
    private String zipCode;

}

