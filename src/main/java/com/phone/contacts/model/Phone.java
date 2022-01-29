package com.phone.contacts.model;

import javax.persistence.*;

@Entity
public class Phone {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "phone_id")
    private int phoneId;

    @Column(name = "type")
    private String type;

    @Column(name = "number")
    private String number;

    @Column(name = "contact_id")
    private Integer contactId;

    public Phone(int phoneId, String type, String number, Integer contactId) {
        this.phoneId = phoneId;
        this.type = type;
        this.number = number;
        this.contactId = contactId;
    }

    public Phone() {
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneId=" + phoneId +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", contactId=" + contactId +
                '}';
    }
}
