package br.inatel.dm110.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.inatel.dm110.entities.Customer;

@Stateless
public class CUSTOMERDAO {
	@PersistenceContext(unitName = "customer_pu")
	private EntityManager em;
	
	public void add(Customer customer) {
		em.persist(customer);
	}
	
	public List<Customer> listAll() {
		Query query = em.createQuery("from Customer c", Customer.class);
		return query.getResultList();
	}
	
//	public Customer list(String cpf) {
//		Query query = em.createQuery("from Customer c where cpf = " + cpf, Customer.class);
//		return query.getFirstResult()
//	}
	
//	public Customer update(Customer customer) {
//		
//	}
}
