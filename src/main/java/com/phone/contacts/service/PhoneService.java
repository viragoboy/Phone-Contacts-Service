package com.phone.contacts.service;

import com.phone.contacts.exceptions.InformationExistException;
import com.phone.contacts.exceptions.InformationNotFoundException;
import com.phone.contacts.model.Contact;
import com.phone.contacts.model.Phone;
import com.phone.contacts.repository.ContactRepository;
import com.phone.contacts.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {

    private PhoneRepository phoneRepository;

    @Autowired
    public void setPhoneRepository(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    private ContactService contactService;

    @Autowired
    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    private ContactRepository contactRepository;

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Phone> getAllPhones(Long userId, Long contactId) {
        // This gives me the contactObject and throws an exception if it doesn't exist. Is calling getContactById() from ContactService.
        Contact contact = contactService.getContactById(userId, contactId);
        return contact.getPhones();
    }

    public Phone createPhone(Long userId, Long contactId, Phone phoneObject) {
        Contact contact = contactService.getContactById(userId, contactId);
        if (contact.getPhones().isEmpty()) {
            phoneObject.setContact(contact);   // This is linking a phone to the contact.
            List<Phone> newPhone = (List<Phone>) phoneRepository.save(phoneObject);
            contact.setPhones(newPhone);
            contactRepository.save(contact);
            return (Phone) newPhone;
        } else {
            throw new InformationExistException("phone for contact id " + contactId + " already exists.");
        }
    }

    public Optional<Phone> getPhoneById(Long userId, Long contactId, Long phoneId) {
        Contact contact = contactService.getContactById(userId, contactId);
        Optional<Phone> phone = this.phoneRepository.getPhoneByContactAndPhoneId(contact, phoneId);
        if (phone.isPresent()) {
            return phone;
        } else {
            throw new InformationNotFoundException("phone with id " + phoneId + " not found.");
        }
    }

    public Phone updatePhone(Long userId, Long contactId, Long phoneId, Phone phoneObject) {
        Contact contact = contactService.getContactById(userId, contactId);
        Optional<Phone> optionalPhone = this.phoneRepository.getPhoneByContactAndPhoneId(contact, phoneId);
        if (optionalPhone.isPresent()) {
            Phone phone = optionalPhone.get();
            phone.setType(phoneObject.getType());
            phone.setNumber(phoneObject.getNumber());
            return phoneRepository.save(phone);
        } else {
            throw new InformationNotFoundException("phone with id " + phoneId + " not found.");
        }
    }

    public Phone deletePhone(Long userId, Long contactId, Long phoneId) {
        Contact contact = contactService.getContactById(userId, contactId);
        Optional<Phone> optionalPhone = this.phoneRepository.getPhoneByContactAndPhoneId(contact, phoneId);
        if (optionalPhone.isPresent()) {
            Phone phone = optionalPhone.get();
            phoneRepository.delete(phone);
            return phone;
        } else {
            throw new InformationNotFoundException("phone with id " + phoneId + " not found.");
        }
    }

}
