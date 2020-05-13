package ua.hbi.PersonManager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.hbi.PersonManager.exception.PersonNotFoundException;
import ua.hbi.PersonManager.model.Person;
import ua.hbi.PersonManager.service.PersonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/persons/")
public class AddBookRestController {

    @Autowired
    private PersonService personService;

    @GetMapping("{id}")
    public Person getPerson(@PathVariable("id") Long personId) {

        Person person = this.personService.get(personId);

        if (person == null) {
            throw  new PersonNotFoundException("Person id not found - " + personId);
        }

        return person;

        }

    @PostMapping(value = "")
    public Person savePerson(@RequestBody @Valid Person person) {

        person.setId(0l);
        personService.save(person);

        return person;
    }

    @PutMapping(value = "")
    public Person updateCustomer(@RequestBody @Valid Person person) {

        personService.save(person);
        return person;
    }

    @DeleteMapping("{id}")
    public String deletePerson(@PathVariable("id") Long personId) {
        Person person = personService.get(personId);

        if (person == null) {
            throw new PersonNotFoundException("Person id not found - " + personId);
        }

        personService.delete(personId);
        return "Deleted customer id - " + personId;
    }

    @GetMapping(value = "")
    public List<Person> getAllPersons() {
        return personService.listAll();
    }
}
