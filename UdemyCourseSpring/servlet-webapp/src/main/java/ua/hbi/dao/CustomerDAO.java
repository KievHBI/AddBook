package ua.hbi.dao;

import org.springframework.stereotype.Repository;
import ua.hbi.entity.Customer;

import java.util.List;


public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);
}
