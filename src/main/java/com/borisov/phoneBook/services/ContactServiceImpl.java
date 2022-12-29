package com.borisov.phoneBook.services;

import com.borisov.phoneBook.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ContactServiceImpl implements ContactService {

    private static final Map<Integer, Contact> CONTACT_REPOSITORY_MAP = new HashMap<>();

    private static final AtomicInteger CONTACT_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Contact contact) {
        final int contactId = CONTACT_ID_HOLDER.incrementAndGet();
        contact.setId(contactId);
        CONTACT_REPOSITORY_MAP.put(contactId, contact);
    }

    @Override
    public List<Contact> readAll() {
        return new ArrayList<>(CONTACT_REPOSITORY_MAP.values());
    }

    @Override
    public Contact read(int id) {
        return CONTACT_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Contact contact, int id) {
        if (CONTACT_REPOSITORY_MAP.containsKey(id)) {
            contact.setId(id);
            CONTACT_REPOSITORY_MAP.put(id, contact);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return CONTACT_REPOSITORY_MAP.remove(id) != null;
    }
}
