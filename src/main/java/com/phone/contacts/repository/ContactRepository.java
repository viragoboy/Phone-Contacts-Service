package com.phone.contacts.repository;

import com.phone.contacts.model.Contact;
import com.phone.contacts.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact getContactByUserAndContactId(User user, Long contactId);

    Contact getContactByUserAndName(User user, String name);

    List<Contact> getAllContactsByUser(User user);
}
