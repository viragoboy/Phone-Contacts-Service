package com.phone.contacts.controller;

import com.phone.contacts.model.Contact;
import com.phone.contacts.model.User;
import com.phone.contacts.service.ContactService;
import com.phone.contacts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")    // url -> http://localhost:9092/api
public class ContactController {

    private ContactService contactService;

    @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/user/{userId}/contact/{contactId}")   // url -> http://localhost:9092/api/user/userId/contact/contactId
    public Contact getContactById(@PathVariable Long userId, @PathVariable Long contactId) {
        System.out.println("calling getContactById");
        return contactService.getContactById(userId, contactId);
    }
}
