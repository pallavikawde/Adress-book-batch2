package com.example.adressbook2.controller;

import com.example.adressbook2.configuration2.MessagingConfig;
import com.example.adressbook2.dto.AddressBookDto;
import com.example.adressbook2.entity.AddressBookEntity;
import com.example.adressbook2.service.AddressBookService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/AddressBook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

   @GetMapping("/listOf-all-books")
   public List<AddressBookDto>getAllListOfBokks(){
       rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTING_KEY,addressBookService.getAllList());
       return addressBookService.getAllList();
   }
    @PostMapping(value="/add-detail")
    public String addDetail( @Valid @RequestBody AddressBookDto addressBookDto){
        return addressBookService.addDetails(addressBookDto);
    }
    @PutMapping(value = "/edit-list/{id}")
    public String updateList(@PathVariable int id,@RequestBody AddressBookDto addressBookDto){
        return addressBookService.updateList(id,addressBookDto);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteAddressBookId(@PathVariable int id){
        return addressBookService.deletAddressBookId(id);
    }
    @GetMapping("/getBy-id/{id}")
    public AddressBookEntity getByiD(@PathVariable int id){
       return addressBookService.getAddressByBookId(id);
    }
}
