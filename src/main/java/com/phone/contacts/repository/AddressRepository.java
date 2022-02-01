package com.phone.contacts.repository;

import com.phone.contacts.model.Address;
import com.phone.contacts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> getAddressByContact(Contact contact);

}
