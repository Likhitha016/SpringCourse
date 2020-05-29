package databaseWebapp.DAO;

import java.util.List;

import databaseWebapp.Entity.Customer;

public interface CustomerDAO {
	public   List<Customer> getCustomers();
	public void saveCustomer(Customer theCustomer);
	public Customer getCustomer(int theId);
	public void deleteCustomer(int theId);
}
