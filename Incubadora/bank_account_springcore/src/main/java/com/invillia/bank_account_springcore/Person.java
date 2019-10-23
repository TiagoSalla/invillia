package com.invillia.bank_account_springcore;

import java.time.LocalDateTime;


public class Person {
    private Long id;
    private String name;
    private String cpf;
    private String rg;

    public Person(Long id, String name, String cpf, String rg) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Long getId() {
        return id;
    }

    public String getRg() {
        return rg;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                '}';
    }
}
