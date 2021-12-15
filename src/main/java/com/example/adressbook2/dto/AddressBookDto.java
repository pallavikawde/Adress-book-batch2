package com.example.adressbook2.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookDto {
   private int id;
    @Pattern(regexp = "^[A-Z][a-z]{2,}$", message = "First name is invalid!!!")
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-z]{2,}$", message = "Last name is invalid!!!")
    private String lastName;

    private String address;

    private String city;

    private String state;

    @Pattern(regexp = "^[91]{2}[ ][0-9]{10}$", message = "Phone number is invalid!!!")
    @Column(unique = true)
    private String phoneNumber;

    @Size(max = 6, message = "Zipcode is invalid!!!")
    private String zipCode;
}

