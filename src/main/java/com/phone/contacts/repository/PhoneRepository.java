package com.phone.contacts.repository;

import com.phone.contacts.model.Contact;
import com.phone.contacts.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    List<Phone> getPhoneByContact(Contact contact);

    Optional<Phone> getPhoneByContactAndPhoneId(Contact contact, Long phoneId);

}
