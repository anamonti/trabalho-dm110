package br.inatel.dm110.interfaces;

import java.util.Collection;

import javax.ws.rs.PathParam;

import br.inatel.dm110.api.CustomerTO;

public interface Customer {
	public void addCustomer(CustomerTO customer);
	
	public CustomerTO getCustomer(String cpf);
	
	public Collection<CustomerTO> getCustomers();
	
	public void updateCustomer(); 
}
