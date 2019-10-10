package com.invillia.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false)
    private Long number;

    @Column(name = "agency", nullable = false)
    private Long agency;

    @Column(name = "type", nullable = false, length = 255)
    private String type;

    @Column(name = "balance", nullable = false)
    private Double balance = 0.00;

    @Column(name = "special_limit", nullable = false)
    private Double specialLimit = 0.00;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Account() {
    }

    public Account(Long number, Long agency, String type, Double balance, Double specialLimit, Client client) {
        this.number = number;
        this.agency = agency;
        this.type = type;
        this.balance = balance;
        this.specialLimit = specialLimit;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Long getAgency() {
        return agency;
    }

    public void setAgency(long agency) {
        this.agency = agency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Double getSpecialLimit() {
        return specialLimit;
    }

    public void setSpecialLimit(double specialLimit) {
        this.specialLimit = specialLimit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number=" + number +
                ", agency=" + agency +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                ", specialLimit=" + specialLimit +
                ", client=" + client +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
