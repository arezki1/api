/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapi.services;



/**
 *
 * @author aibsa
 */

public class TransactionService {
    
    AccountsService accss=new AccountsService();
    
    public double lodge(double transaction){
        
        return accss.postAmount(transaction);
    }
    
}
