/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi.resources;

import com.mycompany.bankapi.model.Accounts;
import com.mycompany.bankapi.model.Customer;
import com.mycompany.bankapi.services.CustomerService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Maurice
 */@Path("/bank")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    
    CustomerService cService = new CustomerService();
    

    @GET
    @Path("/customers")
    public List<Customer> getCustomers() {
         return cService.getAllCustomers();
    }
    
    @GET
    @Path("/accounts")
    public List<Accounts> getAccounts(){
        return cService.getAllAccounts();
    }

    //get the customer by id
    @GET
    @Path("/{customerId}")
    public Customer getCustomer(@PathParam("customerId") int id) {
        return cService.getCustomer(id);
    }
    
    @GET
    @Path("/{customerId}/accounts")
    public Accounts getAccountsById(@PathParam("customerId")int id){
        return cService.getAccountInCustomer(id);
    }
//    @GET
//    @Path("/{customerId}/accounts/{accountId}/balance")
//	public Accounts getCustomer(@PathParam("customerId") int id, @PathParam("accountId") int accId) {
//		return cService.getBalanceOfAccount(id, accId);
//	}
    
    @GET
	public List<Customer> getFilteredCustomers(@QueryParam("id") String id, 
			@QueryParam("name") String name, 
			@QueryParam("address") String address,
                        @QueryParam("email") String email,
                        @QueryParam("balance") Double balance,
			@QueryParam("start") int start,
			@QueryParam("size") int size) {
		if ((name != null) || (email != null) || (address != null)) {
			return cService.getSearchCustomers(address, email, name);
		}
		if (start >= 1 && size > 0 ) {
			return cService.getAllCustomersPaginated(start, size);
		}
		return cService.getAllCustomers();
	} 
 }


