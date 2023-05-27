package br.inatel.dm110.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.interfaces.CustomerRegisterLocal;
import br.inatel.dm110.interfaces.CustomerRegisterRemote;
import br.inatel.dm110.sender.CustomerQueueSender;
import br.inatel.dm110.api.CustomerTO;
import br.inatel.dm110.dao.CustomerDAO;
import br.inatel.dm110.entities.Customer;

@Stateless
@Remote(CustomerRegisterRemote.class)
@Local(CustomerRegisterLocal.class)
public class CustomerBean implements CustomerRegisterLocal, CustomerRegisterRemote {
	@EJB
	private CustomerDAO dao;
	
	@EJB
    private CustomerQueueSender queueSender;

	@Override
	public CustomerTO addCustomer(CustomerTO customer) {
		Customer ct = new Customer(
				customer.getName(), 
				customer.getBirthDate(), 
				customer.getGender(), 
				customer.getEmail(),
				customer.getCep(),
				customer.getCpf());

		dao.addCustomer(ct);
		customer.setId(customer.getId());
		queueSender.sendCustomerCreatedMessage(ct);
		return customer;
	}

	@Override
	public CustomerTO getCustomer(Integer id) {
		Customer customer = dao.getCustomerById(id);

		return getCustomerTO(customer);
	}

	@Override
	public List<CustomerTO> getCustomers() {
		List<CustomerTO> listCustomersTO = new ArrayList<>();

		List<Customer> listCustomers = dao.getCustomers();
		for (Customer customer : listCustomers) {
			listCustomersTO.add(getCustomerTO(customer));
		}

		return listCustomersTO;
	}

	@Override
	public CustomerTO updateCustomer(Integer id, CustomerTO customer) {
		customer.setId(id);

		Customer ct = new Customer(
				customer.getName(), 
				customer.getBirthDate(), 
				customer.getGender(), 
				customer.getEmail(),
				customer.getCep(),
				customer.getCpf());
		Customer updatedCustomer = dao.updateCustomer(ct);
		queueSender.sendCustomerUpdatedMessage(updatedCustomer);
		return getCustomerTO(updatedCustomer);

	}

	private CustomerTO getCustomerTO(Customer customer) {
		if (customer != null) {
			CustomerTO customerTO = new CustomerTO();
			customerTO.setId(customer.getId());
			customerTO.setName(customer.getName());
			customerTO.setEmail(customer.getEmail());
			customerTO.setBirthDate(customer.getBirthDate());
			customerTO.setCpf(customer.getCpf());
			customerTO.setCep(customer.getCep());
			customerTO.setGender(customer.getGender());
			return customerTO;
		}

		return null;
	}
}
