package ua.hbi.PersonManager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.hbi.PersonManager.model.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
