package com.invillia.bank_account_springcore;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDAOImpl implements PersonDAO{
    private List<Person> people = new ArrayList<>();

    @Override
    public void insert(Person person) {
        people.add(person);
    }

    @Override
    public List<Person> findAll() {
        return people;
    }

    @Override
    public Optional<Person> findById(Long id) {
        return people.stream().filter(person -> person.getId().equals(id)).findFirst();
    }
}
