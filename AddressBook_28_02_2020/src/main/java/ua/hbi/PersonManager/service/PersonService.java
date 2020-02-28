package ua.hbi.PersonManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.hbi.PersonManager.model.Person;
import ua.hbi.PersonManager.repo.PersonRepo;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepo repo;

    public List<Person> listAll() {
        return repo.findAll();
    }

    public void save(Person person) {
        repo.save(person);
    }

    public Person get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
