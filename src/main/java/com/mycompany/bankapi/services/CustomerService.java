/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi.services;
import com.mycompany.bankapi.model.Accounts;
import com.mycompany.bankapi.model.Customer;
import com.mycompany.bankapi.model.Transaction;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Maurice
 */
public class CustomerService {
    public static List<Customer> list = new ArrayList<>();
    public static List<Accounts> acc = new ArrayList<>();
    public static List<Transaction> trans=new ArrayList<>();
     
    public static boolean init = true;
    
    public CustomerService() {
     if (init) {
        
        Accounts a1 = new Accounts(1, 5,4,9,5.5, trans);
        Accounts a2 = new Accounts(2, 5,4,10,5.5, trans);
        Accounts a3 = new Accounts(3, 5,4,10,5.5, trans);
        acc.add(a1);
        acc.add(a2);
        
        Customer c1 = new Customer(1,"Maurice", "Swords, Dublin",  "maur@email.com", "bankaccount", acc);
        Customer c2 = new Customer(2,"Arezki", "Clontarf, Dublin", "arezki@email.com", "bankaccount",acc);
        Customer c3 = new Customer(3,"Arezki", "Clontarf, Dublin", "arezki@email.com", "bankaccount",acc);
         
        list.add(c1);
        list.add(c2);
        list.add(c3);
        
    Transaction t1=new Transaction(1,"debit",25,"first withdrw",25.00);
    Transaction t2=new Transaction(2,"debit",2,"second withdrw",2.00);
    
    trans.add(t1);
    trans.add(t2);
        init = false;
     }
    }
        public List<Customer> getAllCustomers(){
        return list;
    }
    
    public Customer getCustomer(int id) {
        return list.get(id-1);
    }
    public Accounts getAccount(int id) {
        return acc.get(id-1);
    }
    
    //get a transaction by id
    public Transaction getTransaction(int customerid, int accountid,int transid){
        
        Transaction t=new Transaction();
        
        try{
         if(getCustomer(customerid).getId()==customerid){
            for (Transaction q: getAccount(accountid).getTrans()) {
        	if (q.getTransId() == transid) {
        		t = q;
        }
        }
           }
          }
        
    catch(Exception e){
        e.getMessage();
        }
                    
        return t;
    }
        //handling the post transactions
    public Transaction postTransaction(Transaction transaction){
        
       // Transaction t=new Transaction();
 
        return transaction;
    }
       
    public Accounts getBalanceOfAccount(int id, int accId) {
        Accounts a = new Accounts();
        
        for (Accounts q: getCustomer(id).getAccounts()) {
        	if (q.getBalance() == accId) {
        		a = q;
        	}
        }
        return a;
    }
    
}
