package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.Contact;
import org.example.repository.DatabasesContactRepository;
import org.example.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DatabasesContactService implements ContactService {

    private final DatabasesContactRepository databasesContactRepository;
    @Override
    public List<Contact> findAll() {
        return databasesContactRepository.findAll();
    }

    @Override
    public Contact findById(Long id) {
        return databasesContactRepository.findById(id).orElse(null);
    }

    @Override
    public Contact save(Contact contact) {
        return databasesContactRepository.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        return databasesContactRepository.save(contact);
    }

    @Override
    public void deleteById(Long id) {
        databasesContactRepository.deleteById(id);
    }
}
