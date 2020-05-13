package ua.hbi.PersonManager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.hbi.PersonManager.model.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {

}
