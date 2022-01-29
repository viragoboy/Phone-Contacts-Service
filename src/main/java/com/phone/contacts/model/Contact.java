package com.phone.contacts.model;

import javax.persistence.*;

@Entity
public class Contact {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "contact_id")
    private int contactId;

    @Column(name = "name")
    private String name;

    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "user_id")
    private Integer userId;

    public Contact(int contactId, String name, Integer addressId, Integer userId) {
        this.contactId = contactId;
        this.name = name;
        this.addressId = addressId;
        this.userId = userId;
    }

    public Contact() {
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", name='" + name + '\'' +
                ", addressId=" + addressId +
                ", userId=" + userId +
                '}';
    }
}
