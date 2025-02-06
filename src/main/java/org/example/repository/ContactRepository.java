package org.example.repository;

import org.example.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactRepository {

    List<Contact> findAll();

    Optional<Contact> findById(Long id);

    Contact save (Contact contact);

    Contact update (Contact contact);

    void deleteById(long id);
}
