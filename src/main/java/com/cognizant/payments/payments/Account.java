package com.cognizant.payments.payments;

import java.util.Objects;

public class Account {
    private int id;

    private String name;
    private Customer customer;
    private double balance;
    private Membership membership;

    public Account(int id, String name, Customer customer, double balance, Membership membership) {
        this.id = id;
        this.name = name;
        this.customer = customer;
        this.balance = balance;
        this.membership = membership;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customer=" + customer +
                ", balance=" + balance +
                ", membership=" + membership +
                '}';
    }
}
