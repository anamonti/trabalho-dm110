package br.inatel.dm110.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;

import br.inatel.dm110.interfaces.CustomerRegisterLocal;
import br.inatel.dm110.api.CustomerService;
import br.inatel.dm110.api.CustomerTO;

@RequestScoped
public class CustomerServiceImpl implements CustomerService {
	@EJB
	private CustomerRegisterLocal customerBean;

	@Override
	public void addCustomer(CustomerTO customer) {
		customerBean.addCustomer(customer);	
	}

	@Override
	public Response getCustomer(Integer id) {
		CustomerTO customerTO = customerBean.getCustomer(id);
		
		if (customerTO != null) {
			return Response.ok(customerTO).build();
		}
		
		return Response.noContent().build();
	}

	@Override
	public List<CustomerTO> getCustomers() {
		return customerBean.getCustomers();
	}

	@Override
	public CustomerTO updateCustomer(Integer id, CustomerTO customerTO) {
		return customerBean.updateCustomer(id, customerTO);
	}

}
