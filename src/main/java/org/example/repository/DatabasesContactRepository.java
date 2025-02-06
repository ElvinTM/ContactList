package org.example.repository;

import org.example.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabasesContactRepository extends JpaRepository<Contact, Long> {
}
