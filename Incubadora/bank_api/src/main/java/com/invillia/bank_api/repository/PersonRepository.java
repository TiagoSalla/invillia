package com.invillia.bank_api.repository;

import com.invillia.bank_api.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
