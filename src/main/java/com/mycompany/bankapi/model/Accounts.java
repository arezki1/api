/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi.model;

/**
 *
 * @author Maurice
 */
public class Accounts {
    
    private int accId;
    private String type;
    private int customerId;
    private double balance;
//    private List <Accounts> accounts;
    
    public Accounts(){
        
    }
    
    public Accounts(int accId, String type, int customerid, double balance){
        
        this.accId = accId;
        this.type = type;
        this.customerId = customerid;
        this.balance = balance;
        
    }
    
    public int getAccId() {
        return accId;
    }

    public void setAccId(int id) {
        this.accId = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
}
