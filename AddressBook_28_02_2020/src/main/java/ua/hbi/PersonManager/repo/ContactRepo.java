package ua.hbi.PersonManager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.hbi.PersonManager.model.Contact;

public interface ContactRepo extends JpaRepository<Contact, Long> {
}
