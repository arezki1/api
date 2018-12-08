/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi.model;

import java.util.Date;

/**
 *
 * @author aibsa
 */
public class Transaction {
    
    private String type;
    private String description;
    private double postTransaction;
    private Date created;
    
    public Transaction(){
        
    }
     public Transaction(String type, String description, double postTransaction){
        this.created=new Date();
        this.description=description;
        this.postTransaction=postTransaction;
        this.created=new Date();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPostTransaction() {
        return postTransaction;
    }

    public void setPostTransaction(double postTransaction) {
        this.postTransaction = postTransaction;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
     
     
}
