package com.invillia.bank_api.domain.response;

import com.invillia.bank_api.enums.AccountType;

public class AccountResponse {

    private Long id;

    private Long personId;

    private String personName;

    private Long number;

    private Long agency;

    private AccountType accountType;

    private Double balance;

    private Double specialLimit;

    private Double availableSpecialLimit;

    private String createdAt;

    private String updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getAgency() {
        return agency;
    }

    public void setAgency(Long agency) {
        this.agency = agency;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getSpecialLimit() {
        return specialLimit;
    }

    public void setSpecialLimit(Double specialLimit) {
        this.specialLimit = specialLimit;
    }

    public Double getAvailableSpecialLimit() {
        return availableSpecialLimit;
    }

    public void setAvailableSpecialLimit(Double availableSpecialLimit) {
        this.availableSpecialLimit = availableSpecialLimit;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
