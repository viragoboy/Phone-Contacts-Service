package com.phone.contacts.repository;

import com.phone.contacts.model.Contact;
import com.phone.contacts.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact getContactByUserAndContactId(User user, Long contactId);
}
