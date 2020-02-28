package ua.hbi.PersonManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.hbi.PersonManager.model.Address;
import ua.hbi.PersonManager.repo.AddressRepo;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    public List<Address> listAll() {
        return addressRepo.findAll();
    }

    public void saveAddress(Address address) {
        addressRepo.save(address);
    }

    public Address get(Long id) {
        return addressRepo.findById(id).get();
    }

    public void delete(Long id) {
        addressRepo.deleteById(id);
    }
}