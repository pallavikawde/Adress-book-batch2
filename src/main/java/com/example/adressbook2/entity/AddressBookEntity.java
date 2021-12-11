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
    @Column(name = "address_id")
    private int id;
    @Column(name = "name1")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "zip")
    private int zip;

}
