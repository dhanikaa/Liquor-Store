package com.architecture.Liquor.Store.service;

import com.architecture.Liquor.Store.dto.ContactDto;
import com.architecture.Liquor.Store.entity.Contact;
import com.architecture.Liquor.Store.repository.ContactRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ModelMapper modelMapper;
    public ContactDto saveContact(ContactDto contactDto) {
        contactRepository.save(modelMapper.map(contactDto, Contact.class));
        return contactDto;
    }

    public List<ContactDto> getAllContacts() {
       List<Contact>contactList = contactRepository.findAll();
       return modelMapper.map(contactList,new TypeToken<List<ContactDto>>(){}.getType());
    }

    public boolean deleteContact(ContactDto contactDto) {
        contactRepository.delete(modelMapper.map(contactDto, Contact.class ));
        return true;
    }
}
