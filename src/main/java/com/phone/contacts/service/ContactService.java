package com.phone.contacts.service;

import com.phone.contacts.exceptions.InformationExistException;
import com.phone.contacts.exceptions.InformationNotFoundException;
import com.phone.contacts.model.Contact;
import com.phone.contacts.model.Phone;
import com.phone.contacts.model.User;
import com.phone.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    private PhoneService phoneService;

    @Autowired
    public void setPhoneService(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    public List<Contact> getAllContacts(Long userId) {
    // This gives me the userObject and throws an exception if it doesn't exist. Is calling getUser() from UserService.
        User user = userService.getUser(userId).get();
        List<Contact> contact = contactRepository.getAllContactsByUser(user);
        return contact;
    }

    public Contact createContact(Long userId, Contact contactObject) {
        User user = userService.getUser(userId).get();
        Contact contact = contactRepository.getContactByUserAndName(user, contactObject.getName());
        if (contact == null) {
            contactObject.setUser(user);   // This is linking a contact to the user.
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
            contact.setName(contactObject.getName());   // This updates the name in the contactObject.
            return contactRepository.save(contact);
        } else {
            throw new InformationNotFoundException("contact with id " + contactId + " not found.");
        }
    }

    public Contact deleteContact(Long userId, Long contactId) {
        User user = userService.getUser(userId).get();
        Contact contact = contactRepository.getContactByUserAndContactId(user, contactId);
        if (contact != null) {
    //  The database is not allowing me to delete a contact that still has at least one phone number in it, so I'm iterating inside the phone list and deleting the phone(s) it contains:
            if (!contact.getPhones().isEmpty()) {
               List<Phone> phones = contact.getPhones();
                for (Phone phone : phones) {
                    phoneService.deletePhone(userId, contactId, phone.getPhoneId());
                }
            }
            contactRepository.delete(contact);
            return contact;
        } else {
            throw new InformationNotFoundException("contact with id " + contactId + " not found.");
        }
    }

}
