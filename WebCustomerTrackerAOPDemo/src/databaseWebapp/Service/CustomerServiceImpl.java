package databaseWebapp.Service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import databaseWebapp.DAO.CustomerDAO;
import databaseWebapp.Entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		if(theCustomer.getFirstName()!="" && theCustomer.getLastName()!="" && theCustomer.getEmail()!="")
		{

		customerDAO.saveCustomer(theCustomer);}
	}
	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}
	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
	}
}
