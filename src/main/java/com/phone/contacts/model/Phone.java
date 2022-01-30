package com.phone.contacts.model;

import javax.persistence.*;

@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @Column(name = "phone_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phoneId;

    @Column(name = "type")
    private String type;

    @Column(name = "number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Phone(int phoneId, String type, String number, Integer contactId) {
        this.phoneId = phoneId;
        this.type = type;
        this.number = number;
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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneId=" + phoneId +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

}
