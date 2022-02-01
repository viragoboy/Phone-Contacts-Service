package com.phone.contacts.service;

import com.phone.contacts.exceptions.InformationExistException;
import com.phone.contacts.exceptions.InformationNotFoundException;
import com.phone.contacts.model.Address;
import com.phone.contacts.model.Contact;
import com.phone.contacts.repository.AddressRepository;
import com.phone.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<Address> address = addressRepository.getAddressByContact(contact);
        if (address.size() == 0) {
            addressObject.setContact(contact);
            Address newAddress = addressRepository.save(addressObject);
            contact.setAddress(newAddress);
            contactRepository.save(contact);
            return newAddress;
        } else {
            throw new InformationExistException("address " + addressObject + " already exists.");
        }
    }

    public List<Address> getAddressById(Long userId, Long contactId, Long addressId) {
        Contact contact = contactService.getContactById(userId, contactId);
        List<Address> address  = addressRepository.getAddressByContact(contact);
        if (address.size() != 0) {
            return address;
        } else {
            throw new InformationNotFoundException("address with id " + addressId + " not found.");
        }
    }

}
