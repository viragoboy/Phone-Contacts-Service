package com.phone.contacts.controller;

import com.phone.contacts.model.Phone;
import com.phone.contacts.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")    // url -> http://localhost:9092/api
public class PhoneController {

    private PhoneService phoneService;

    @Autowired
    public void setPhoneService(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/user/{userId}/contact/{contactId}/phone")   // url -> http://localhost:9092/api/user/userId/contact/contactId/phone
    public List<Phone> getAllPhones(@PathVariable Long userId, @PathVariable Long contactId) {
        System.out.println("calling getAllPhones");
        return phoneService.getAllPhones(userId, contactId);
    }

}
