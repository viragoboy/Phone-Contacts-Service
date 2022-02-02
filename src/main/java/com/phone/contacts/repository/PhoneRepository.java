package com.phone.contacts.repository;

import com.phone.contacts.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
