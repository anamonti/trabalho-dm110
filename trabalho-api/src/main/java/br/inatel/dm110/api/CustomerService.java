package br.inatel.dm110.api;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
public interface CustomerService {
	@POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public void addCustomer(CustomerTO customer);
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomer(@PathParam("id") Integer id);
	
	@GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
	public List<CustomerTO> getCustomers();
	
	@PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    CustomerTO updateCustomer(@PathParam("id") Integer id, CustomerTO customerTO);
}
