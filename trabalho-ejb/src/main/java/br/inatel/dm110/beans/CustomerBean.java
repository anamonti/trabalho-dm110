package br.inatel.dm110.beans;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.interfaces.CustomerLocal;
import br.inatel.dm110.interfaces.CustomerRemote;
import br.inatel.dm110.api.CustomerTO;
import br.inatel.dm110.dao.CUSTOMERDAO;
import br.inatel.dm110.entities.Customer;

@Stateless 
@Remote(CustomerRemote.class)
@Local(CustomerLocal.class)
public class CustomerBean implements CustomerLocal, CustomerRemote{

	@EJB
	private CUSTOMERDAO dao;
	
	@Override
	public void addCustomer(CustomerTO customer) {
		Customer ct = new Customer();
		
		ct.setCpf(customer.getCpf());
		ct.setName(customer.getName());
		ct.setBirthDate(customer.getBirthDate());
		ct.setGender(customer.getGender());
		ct.setEmail(customer.getEmail());
		ct.setCep(customer.getCep());
		
		dao.add(ct);
	}
}
