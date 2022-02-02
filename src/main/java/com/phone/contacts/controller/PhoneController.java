package com.phone.contacts.controller;

import com.phone.contacts.model.Phone;
import com.phone.contacts.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/user/{userId}/contact/{contactId}/phone")   // url -> http://localhost:9092/api/user/userId/contact/contactId/phone
    public Phone createPhone(@PathVariable Long userId, @PathVariable Long contactId, @RequestBody Phone phoneObject) {
        System.out.println("calling createPhone");
        return phoneService.createPhone(userId, contactId, phoneObject);
    }

}
