package com.phone.contacts.service;

import com.phone.contacts.exceptions.InformationExistException;
import com.phone.contacts.exceptions.InformationNotFoundException;
import com.phone.contacts.model.Contact;
import com.phone.contacts.model.User;
import com.phone.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Contact> getAllContacts(Long userId) {
        User user = userService.getUser(userId).get();
        List<Contact> contact = contactRepository.getAllContactsByUser(user);
        return contact;
    }

    public Contact createContact(Long userId, Contact contactObject) {
        User user = userService.getUser(userId).get();
        Contact contact = contactRepository.getContactByUserAndName(user, contactObject.getName());
        if (contact == null) {
            contactObject.setUser(user);
            return contactRepository.save(contactObject);
        } else {
            throw new InformationExistException("contact " + contactObject.getName() + " already exists.");
        }
    }

    public Contact getContactById(Long userId, Long contactId) {
        User user = userService.getUser(userId).get();
        Contact contact  = contactRepository.getContactByUserAndContactId(user, contactId);
        if (contact != null) {
            return contact;
        } else {
            throw new InformationNotFoundException("contact with id " + contactId + " not found.");
        }
    }

    public Contact updateContact(Long userId, Long contactId, Contact contactObject) {
        User user = userService.getUser(userId).get();
        Contact contact = contactRepository.getContactByUserAndContactId(user, contactId);
        if (contact != null) {
            contact.setName(contactObject.getName());
            return contactRepository.save(contact);
        } else {
            throw new InformationNotFoundException("contact with id " + contactId + " not found.");
        }
    }

    public Contact deleteContact(Long userId, Long contactId) {
        User user = userService.getUser(userId).get();
        Contact contact  = contactRepository.getContactByUserAndContactId(user, contactId);
        if (contact != null) {
            contactRepository.delete(contact);
            return contact;
        } else {
            throw new InformationNotFoundException("contact with id " + contactId + " not found.");
        }
    }

}
