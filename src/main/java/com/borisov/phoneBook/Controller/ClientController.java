package com.borisov.phoneBook.Controller;

import com.borisov.phoneBook.Contact;
import com.borisov.phoneBook.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    private final ContactService contactService;

    @Autowired
    public ClientController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping(value = "/contacts")
    public ResponseEntity<?> create(@RequestBody Contact contact) {
        contactService.create(contact);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/contacts")
    public ResponseEntity<List<Contact>> read() {
        final List<Contact> contacts = contactService.readAll();

        return contacts != null &&  !contacts.isEmpty()
                ? new ResponseEntity<>(contacts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/contacts/{id}")
    public ResponseEntity<Contact> read(@PathVariable(name = "id") int id) {
        final Contact contact = contactService.read(id);

        return contact != null
                ? new ResponseEntity<>(contact, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/contacts/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Contact contact) {
        final boolean updated = contactService.update(contact, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/contacts/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = contactService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
