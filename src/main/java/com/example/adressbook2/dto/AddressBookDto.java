package com.example.adressbook2.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressBookDto {

   @Pattern(regexp = "^[A-Z][a-z]{2,}$")
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-z]{2,}$")
    private String lastName;

    private String address;

    private String city;

    private String state;

    @Pattern(regexp = "^[91]{2}[ ][0-9]{10}$")
    @Column(unique = true)
    private String phoneNumber;

   @Size(max = 6)
    private String zipCode;
//   private String OrderId;
//    private String name;
//    private String qty;
//    private double price;
}

