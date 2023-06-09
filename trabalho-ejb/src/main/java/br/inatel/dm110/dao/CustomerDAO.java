package br.inatel.dm110.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.dm110.entities.Customer;

@Stateless
public class CustomerDAO {
	@PersistenceContext(unitName = "trabalho_dm110_pu")
	private EntityManager em;
	
	public void addCustomer(Customer customer) {
		em.persist(customer);
	}
	
	public List<Customer> getCustomers() {
		return em.createQuery("from Customer c", Customer.class).getResultList();
	}
	
	public Customer getCustomerById(Integer id) {
		return em.createQuery("from Customer c where id = '" + id + "'", Customer.class).getSingleResult();
	}
	
	public Customer updateCustomer(Customer customer) {
		return em.merge(customer);		
	}
}
