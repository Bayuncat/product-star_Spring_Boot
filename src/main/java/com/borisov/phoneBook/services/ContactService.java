package com.borisov.phoneBook.services;

import com.borisov.phoneBook.Contact;

import java.util.List;

public interface ContactService {

    void create(Contact contact);
    List<Contact> readAll();
    Contact read(int id);
    boolean update(Contact contact, int id);
    boolean delete(int id);

}
