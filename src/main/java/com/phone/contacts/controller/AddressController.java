package com.phone.contacts.controller;

import com.phone.contacts.model.Address;
import com.phone.contacts.model.Contact;
import com.phone.contacts.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")    // url -> http://localhost:9092/api
public class AddressController {

    private AddressService addressService;

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/user/{userId}/contact/{contactId}/address")   // url -> http://localhost:9092/api/user/userId/contact/contactId/address
    public List<Address> getAllAddresses(@PathVariable Long userId, @PathVariable Long contactId) {
        System.out.println("calling getAllAddresses");
        return addressService.getAllAddresses(userId, contactId);
    }

    @PostMapping("/user/{userId}/contact/{contactId}/address")   // url -> http://localhost:9092/api/user/userId/contact/contactId/address
    public Address createAddress(@PathVariable Long userId, @PathVariable Long contactId, @RequestBody Address addressObject) {
        System.out.println("calling createAddress");
        return addressService.createAddress(userId, contactId, addressObject);
    }

}
