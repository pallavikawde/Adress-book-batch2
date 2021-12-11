package com.example.adressbook2.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmptyInputException extends RuntimeException {
    private String errorCode;
    private String errorMessage;


}