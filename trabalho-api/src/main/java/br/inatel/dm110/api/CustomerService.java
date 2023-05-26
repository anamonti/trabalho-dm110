package br.inatel.dm110.api;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/customer")
public interface CustomerService {
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addCustomer(CustomerTO customer);
	
	@GET
	@Path("/get/{cpf}")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomerTO getCustomer(@PathParam("cpf") String cpf);
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CustomerTO> getCustomers();
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCustomer();
}
