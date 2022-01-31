package com.phone.contacts.service;

import com.phone.contacts.exceptions.InformationNotFoundException;
import com.phone.contacts.model.Contact;
import com.phone.contacts.model.User;
import com.phone.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Contact getContactById(Long userId, Long contactId){
        User user = userService.getUser(userId).get();
        Contact contact  = contactRepository.getContactByUserAndContactId(user, contactId);
        if (contact != null) {
            return contact;
        } else {
            throw new InformationNotFoundException("contact with id " + contactId + " not found.");
        }
    }
}
