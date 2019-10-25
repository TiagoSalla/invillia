package com.invillia.bankspringdatajpa.repository;

import com.invillia.bankspringdatajpa.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
