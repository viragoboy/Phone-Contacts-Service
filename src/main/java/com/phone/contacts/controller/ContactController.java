package com.phone.contacts.controller;

import com.phone.contacts.model.Contact;
import com.phone.contacts.model.User;
import com.phone.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")    // url -> http://localhost:9092/api
public class ContactController {

    private ContactService contactService;

    @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/user/{userId}/contact")   // url -> http://localhost:9092/api/user/userId/contact
    public List<Contact> getAllContacts(@PathVariable Long userId) {
        System.out.println("calling getAllContacts");
        return contactService.getAllContacts(userId);
    }

    @PostMapping("/user/{userId}/contact")   // url -> http://localhost:9092/api/user/userId/contact
    public Contact createContact(@PathVariable Long userId, @RequestBody Contact contactObject) {
        System.out.println("calling createContact");
        return contactService.createContact(userId, contactObject);
    }

    @GetMapping("/user/{userId}/contact/{contactId}")   // url -> http://localhost:9092/api/user/userId/contact/contactId
    public Contact getContactById(@PathVariable Long userId, @PathVariable Long contactId) {
        System.out.println("calling getContactById");
        return contactService.getContactById(userId, contactId);
    }

    @PutMapping("/user/{userId}/contact/{contactId}")   // url -> http://localhost:9092/api/user/userId/contact/contactId
    public Contact updateContact(@PathVariable Long userId, @PathVariable Long contactId, @RequestBody Contact contactObject) {
        System.out.println("calling updateContact");
        return contactService.updateContact(userId, contactId, contactObject);
    }

}
