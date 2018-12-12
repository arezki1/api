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
    public static List<Transaction> trans = new ArrayList<>();

    public static boolean init = true;

    public CustomerService() {
        if (init) {

            Accounts a1 = new Accounts(1, 5, 4, 9, 5.5, trans);
            Accounts a2 = new Accounts(2, 5, 4, 10, 5.5, trans);
            Accounts a3 = new Accounts(3, 5, 4, 10, 5.5, trans);
            acc.add(a1);
            acc.add(a2);

            Customer c1 = new Customer(1, "Maurice", "Swords, Dublin", "maur@email.com", "bankaccount", acc);
            Customer c2 = new Customer(2, "Arezki", "Clontarf, Dublin", "arezki@email.com", "bankaccount", acc);
            Customer c3 = new Customer(3, "Arezki", "Clontarf, Dublin", "arezki@email.com", "bankaccount", acc);

            list.add(c1);
            list.add(c2);
            list.add(c3);

            Transaction t1 = new Transaction(1, "debit", 1, 25, "first withdrw", 25.00);
            Transaction t2 = new Transaction(2, "debit", 2, 2, "second withdrw", 2.00);

            trans.add(t1);
            trans.add(t2);
            init = false;
        }
    }
    //service to return all customers
    public List<Customer> getAllCustomers() {
        return list;
    }
    //servie to return a single customer
    public Customer getCustomer(int id) {
        return list.get(id - 1);
    }
//    service to return a single account
    public Accounts getAccount(int id) {
        return acc.get(id - 1);
    }

    //get a transaction by id
    public Transaction getTransaction(int customerid, int accountid, int transid) {

        Transaction t = new Transaction();

        try {
            if (getCustomer(customerid).getId() == customerid) {
                for (Transaction q : getAccount(accountid).getTrans()) {
                    if (q.getTransId() == transid) {
                        t = q;
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return t;
    }

//    get all transactions for an account by account Id
    public Transaction getTransactionbyAccId(int customerid, int accId) {

        Accounts a = new Accounts();
        Transaction t = new Transaction();

        try {
            if (getCustomer(customerid).getId() == customerid) {
                if (getAccount(accId).getId() == accId) {
                    a.getTrans();
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return t;
    }

    //handling the put transactions for debit - Arezki
    public double putCredit(Transaction transaction) {

        if (transaction.getAccountNumber() == getAccount(transaction.getAccountNumber()).getAccountNumber()) {

            try {
                double balance = getAccount(transaction.getAccountNumber()).getBalance();
                double newBalance = balance - transaction.getAmount();
                getAccount(transaction.getAccountNumber()).setBalance(newBalance);

                return newBalance;
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return 10.00;
    }

    //handling the put transactions for debit
    public double putDebit(Transaction transaction) {

        if (transaction.getAccountNumber() == getAccount(transaction.getAccountNumber()).getAccountNumber()) {

            try {
                double balance = getAccount(transaction.getAccountNumber()).getBalance();
                double newBalance = balance + transaction.getAmount();
                getAccount(transaction.getAccountNumber()).setBalance(newBalance);

                return newBalance;
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return 10.00;
    }

    //handling the post transactions
    public Transaction postTransaction(Transaction transaction) {

        // Transaction t=new Transaction();
        return transaction;
    }

    public Accounts getBalanceOfAccount(int id, int accId) {
        Accounts a = new Accounts();

        for (Accounts q : getCustomer(id).getAccounts()) {
            if (q.getBalance() == accId) {
                a = q;
            }
        }
        return a;
    }

    //service to create a new customer
    public Customer createCustomer(Customer c) {
        c.setId(list.size() + 1);
        list.add(c);
        System.out.println("201 - resource created with path: /createcust/" + String.valueOf(c.getId()));
        return c;
    }

    //service to create an account
    public Accounts createAccount(Accounts a, int customerid) {
        Customer c = new Customer();
        try {
            if (getCustomer(customerid).getId() == customerid) {
                a.setId(list.size() + 1);
                acc.add(a);
                System.out.println("201 - resource created with path: /createacc/" + String.valueOf(a.getId()));

            }

        } catch (Exception e) {
            e.getMessage();
        }
        return a;

    }

}
