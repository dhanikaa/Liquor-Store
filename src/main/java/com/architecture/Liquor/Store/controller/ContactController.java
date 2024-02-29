package com.architecture.Liquor.Store.controller;


import com.architecture.Liquor.Store.dto.ContactDto;
import com.architecture.Liquor.Store.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1/contact")
@CrossOrigin
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/getContact")
    public List<ContactDto> getContact(){
        return contactService.getAllContacts();
    }

    @PostMapping("/saveContact")
    public ContactDto saveContact(@RequestBody ContactDto contactDto){
        return contactService.saveContact(contactDto);
    }

    @PutMapping("/updateContact")
    public String updateContact(){
        return "contact Updated";
    }

    @DeleteMapping("/deleteContact")
    public boolean deleteContact(@RequestBody ContactDto contactDto){
        return contactService.deleteContact(contactDto);
    }

}
