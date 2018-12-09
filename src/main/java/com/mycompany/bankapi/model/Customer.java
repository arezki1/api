/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi.model;

import java.util.List;



/**
 *
 * @author Maurice
 */
public class Customer {
    //Set variables
    private int id;
    private String name;
    private String address;
    private String email;
    private String password; 
    private List <Accounts> accounts;
    
    public Customer(){
        
    }
    
    public Customer(int id, String name, String address, String email, String password, List <Accounts> accounts){
    
            this.id = id;
            this.name = name;
            this.address = address;
            this.email = email;
            this.password = password;
            this.accounts = accounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }

   

    
    
    
    
 }
