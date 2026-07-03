package com.enterprise.domain;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account extends AbstractAuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private double balance;

    public Account() {
    }

    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account[id=" + id + ", owner=" + owner + ", balance=" + balance + "]";
    }
}
