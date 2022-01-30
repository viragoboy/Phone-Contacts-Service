package com.phone.contacts.repository;

import com.phone.contacts.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String userName);

}
