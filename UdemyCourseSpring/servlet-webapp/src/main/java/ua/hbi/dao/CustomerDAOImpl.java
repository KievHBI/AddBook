package ua.hbi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.hbi.entity.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    // need to the inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
//        Query<Customer> theQuery = currentSession.createQuery("from Cus", Customer.class);
        Query<Customer> theQuery =
                currentSession.createQuery("from Customer", Customer.class);

        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        //return the results

        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save the customer ... finally
        currentSession.save(theCustomer);
    }
}
