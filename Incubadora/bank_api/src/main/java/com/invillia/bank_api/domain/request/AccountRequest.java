package com.invillia.bank_api.domain.request;

import javax.validation.constraints.NotNull;

public class AccountRequest {

    private Long personId;

    @NotNull(message = "This field cannot be Null!")
    private Long number;

    @NotNull(message = "This field cannot be Null!")
    private Long agency;

    private String accountType;

    @NotNull(message = "This field cannot be Null!")
    private Double specialLimit;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getSpecialLimit() {
        return specialLimit;
    }

    public void setSpecialLimit(Double specialLimit) {
        this.specialLimit = specialLimit;
    }

}
