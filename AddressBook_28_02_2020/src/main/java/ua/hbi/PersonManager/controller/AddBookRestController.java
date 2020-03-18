package ua.hbi.PersonManager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ua.hbi.PersonManager.model.Person;
import ua.hbi.PersonManager.service.PersonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/persons/")
public class AddBookRestController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long personId) {
        if (personId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Person person = this.personService.get(personId);

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(person, HttpStatus.OK);

        }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Person> savePerson(@RequestBody @Valid Person person) {
        HttpHeaders headers = new HttpHeaders();

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.personService.save(person);
        return new ResponseEntity<>(person, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<Person> updatePerson(@RequestBody @Valid Person person, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.personService.save(person);

        return new ResponseEntity<>(person, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Person> deletePerson(@PathVariable("id") Long id) {
        Person person = this.personService.get(id);

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.personService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = this.personService.listAll();

        if (persons.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
