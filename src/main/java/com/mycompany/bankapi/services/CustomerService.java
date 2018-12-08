/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi.services;

import com.mycompany.bankapi.model.Accounts;
import com.mycompany.bankapi.model.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maurice
 */
public class CustomerService {
    public static List<Customer> list = new ArrayList<>();
    public static List<Accounts> acc = new ArrayList<>();
    
    public static boolean init = true;
    
    public CustomerService() {
     if (init) {
        
        Accounts a1 = new Accounts(99901, "C", 101, 2550.65);
        Accounts a2 = new Accounts(99902, "C", 102, 1400.26);
        Accounts a3 = new Accounts(99911, "S", 101, 3000.21);
        Accounts a4 = new Accounts(99912, "S", 102, 1800.12);
        
        acc.add(a1);
        acc.add(a2);
        acc.add(a3);
        acc.add(a4);
        
        Customer c1 = new Customer(1,"Maurice", "Swords, Dublin",  "maur@email.com", "bankaccount", acc);
        Customer c2 = new Customer(2,"Arezki", "Clontarf, Dublin", "arezki@email.com", "bankaccount",acc);
        
       
        list.add(c1);
        list.add(c2);
//        list.add(c3);
//        list.add(c4);
//        list.add(c5);
//        list.add(c6);
//        list.add(c7);
//        list.add(c8);
//        list.add(c9);
//        list.add(c10);
        init = false;
     }
    }
    
    public List<Customer> getAllCustomers(){
        return list;
    }
    
    public Customer getCustomer(int id) {
        return list.get(id-1);
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
