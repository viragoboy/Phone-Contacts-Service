package com.phone.contacts.service;

import com.phone.contacts.exceptions.InformationExistException;
import com.phone.contacts.exceptions.InformationNotFoundException;
import com.phone.contacts.model.Address;
import com.phone.contacts.model.Contact;
import com.phone.contacts.repository.AddressRepository;
import com.phone.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
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

    public Address getAddress(Long userId, Long contactId) {
        // This gives me the contactObject and throws an exception if it doesn't exist. Is calling getContact() from ContactService.
        Contact contact = contactService.getContactById(userId, contactId);
        return contact.getAddress();
    }

    public Address createAddress(Long userId, Long contactId, Address addressObject) {
        Contact contact = contactService.getContactById(userId, contactId);
        if (contact.getAddress() == null) {
            addressObject.setContact(contact);   // This is linking an address to the contact.
            Address newAddress = addressRepository.save(addressObject);
            contact.setAddress(newAddress);
            contactRepository.save(contact);
            return newAddress;
        } else {
            throw new InformationExistException("address for contact id " + contactId + " already exists.");
        }
    }

    public Address getAddressById(Long userId, Long contactId, Long addressId) {
        Contact contact = contactService.getContactById(userId, contactId);
        if (contact.getAddress().getAddressId() == addressId) {
            return contact.getAddress();
        } else {
            throw new InformationNotFoundException("address with id " + addressId + " not found.");
        }
    }

    public Address updateAddress(Long userId, Long contactId, Long addressId, Address addressObject) {
        Contact contact = contactService.getContactById(userId, contactId);
        if (contact.getAddress() != null && contact.getAddress().getAddressId() == addressId) {
            contact.getAddress().setStreet(addressObject.getStreet());
            contact.getAddress().setCity(addressObject.getCity());
            contact.getAddress().setState(addressObject.getState());
            contact.getAddress().setZipCode(addressObject.getZipCode());
            return addressRepository.save(contact.getAddress());
        } else {
            throw new InformationNotFoundException("address with id " + addressId + " not found.");
        }
    }

    public Address deleteAddress(Long userId, Long contactId, Long addressId) {
        Contact contact = contactService.getContactById(userId, contactId);
        if (contact.getAddress() != null && contact.getAddress().getAddressId() == addressId) {
    // Now that I have a valid contact object, let's set the address to null.
    // Setting it to null and then saving the contact tells JPA that there are no more references to that Address record, and it deletes it.
            contact.setAddress(null);
            contactRepository.save(contact);
            return contact.getAddress();
        } else {
            throw new InformationNotFoundException("address with id " + addressId + " not found.");
        }
    }

}
