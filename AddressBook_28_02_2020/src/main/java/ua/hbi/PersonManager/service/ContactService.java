package ua.hbi.PersonManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.hbi.PersonManager.model.Contact;
import ua.hbi.PersonManager.repo.ContactRepo;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepo contactRepo;

    public List<Contact> listAll() {
        return contactRepo.findAll();
    }

    public void saveContact(Contact contact) {
        contactRepo.save(contact);
    }

    public Contact get(Long id) { return contactRepo.findById(id).get();
    }

    public void delete(Long id) { contactRepo.deleteById(id);
    }
}
