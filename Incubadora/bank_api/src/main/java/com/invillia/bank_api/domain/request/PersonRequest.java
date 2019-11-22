package com.invillia.bank_api.domain.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonRequest {

    @NotNull(message = "This field cannot be Null!")
    @NotBlank(message = "This field cannot be Blank!")
    private String name;

    @NotNull(message = "This field cannot be Null!")
    @NotBlank(message = "This field cannot be Blank!")
    private String cpf;

    @NotNull(message = "This field cannot be Null!")
    @NotBlank(message = "This field cannot be Blank!")
    private String rg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

}

