/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi.resources;

import com.mycompany.bankapi.model.Accounts;
import com.mycompany.bankapi.model.Customer;
import com.mycompany.bankapi.model.Transaction;
import com.mycompany.bankapi.services.CustomerService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    public List<Customer> getAllCustomers() {
         return cService.getAllCustomers();
    }

    //get the customer by id
    @GET
    @Path("/customer/{customerId}")
    public Customer getCustomerById(@PathParam("customerId") int id) {
        return cService.getCustomer(id);
    }
    
  
   //get the transaction by id
    @GET
    @Path("{custId}/acc/{accId}/trans/{transId}")
    public Transaction getTransactionbyId(@PathParam("custId") int customerid,@PathParam("accId") int accountid,@PathParam("transId") int transid) {
        return cService.getTransaction(customerid, accountid,transid);
              
    }
       //create a transaction
    @PUT
    @Path("transaction")
    public double postTransaction(Transaction debit){
               
            if( debit.getType().equals("debit")){
             return cService.putDebit(debit);
        }
            
            else if( debit.getType().equals("credit")){
             return cService.putCredit(debit);
        }
       
            return 5.7;
             
    }
    //get all transactions for an account
//    @GET
//    @Path("{custId}/acc/{accId}")
//    public <List>Transaction getTransactionbyAccId(@PathParam(int custId), @PathParam (int accId){
//        
//    }
    
    //create a customer
    @POST
    @Path("/createcust")
    public Customer postCustomer(Customer c){
        return cService.createCustomer(c);
    } 
    //create an account
    @POST
    @Path("{custId}/createacc")
    public Accounts postAccount(@PathParam("custId")int id, Accounts a){
      return cService.createAccount(a, id);
    }
   
}
