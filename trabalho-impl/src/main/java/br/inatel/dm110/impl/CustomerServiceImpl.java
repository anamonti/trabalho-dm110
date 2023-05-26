package br.inatel.dm110.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.api.CustomerService;
import br.inatel.dm110.api.CustomerTO;

@RequestScoped
public class CustomerServiceImpl implements CustomerService {
	@EJB(lookup="ejb:")
	private CustomerRemote customerBean;

	@Override
	public void addCustomer(CustomerTO customer) {
		customerBean.addCustomer(customer);	
	}

	@Override
	public CustomerTO getCustomer(String cpf) {
		return customerBean.list(cpf);
	}

	@Override
	public List<CustomerTO> getCustomers() {
		return customerBean.listAll();
	}

	@Override
	public void updateCustomer() {
		customerBean.updateCustomer();
	}

}
