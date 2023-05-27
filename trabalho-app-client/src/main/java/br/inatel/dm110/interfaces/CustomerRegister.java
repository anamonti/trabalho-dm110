package br.inatel.dm110.interfaces;

import java.util.List; 

import br.inatel.dm110.api.CustomerTO;

public interface CustomerRegister {
	public CustomerTO addCustomer(CustomerTO customer);
	
	public CustomerTO getCustomer(Integer id);
	
	public List<CustomerTO> getCustomers();
	
	public CustomerTO updateCustomer(Integer id, CustomerTO customerTO); 
}
