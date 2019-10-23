package com.invillia.bank_account_springcore;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface PersonDAO {
    void insert(Person person);

    List<Person> findAll();

    Optional<Person> findById(Long id);
}
