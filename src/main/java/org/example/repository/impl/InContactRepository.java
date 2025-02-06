package org.example.repository.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.Contact;
import org.example.repository.ContactRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
@RequiredArgsConstructor
public class InContactRepository implements ContactRepository {

    private final Map<Long, Contact> contactMap = new ConcurrentHashMap<>();

    private final AtomicLong atomicLong = new AtomicLong();

    @Override
    public List<Contact> findAll() {
        return new ArrayList<>(contactMap.values());
    }

    @Override
    public Optional<Contact> findById(Long id) {
        return Optional.ofNullable(contactMap.get(id));
    }

    @Override
    public Contact save(Contact contact) {
        Long contactId = atomicLong.incrementAndGet();
        contact.setId(contactId);
        contactMap.put(contactId, contact);
        return contact;
    }

    @Override
    public Contact update(Contact contact) {
        Long contactId = contact.getId();
        Contact currentContact = contactMap.get(contactId);
        currentContact.setId(contactId);
        contactMap.put(contactId, currentContact);
        return currentContact;
    }

    @Override
    public void deleteById(long id) {
        contactMap.remove(id);
    }
}
