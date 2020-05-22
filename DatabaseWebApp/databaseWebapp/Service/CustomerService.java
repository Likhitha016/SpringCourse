package databaseWebapp.Service;
import java.util.List;

import databaseWebapp.Entity.Customer;;
public interface CustomerService {
	public List<Customer> getCustomers();
	public void saveCustomer(Customer theCustomer);
	public Customer getCustomer(int theId);
	public void deleteCustomer(int theId);
}
