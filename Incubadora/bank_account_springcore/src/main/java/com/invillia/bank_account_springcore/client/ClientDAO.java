package com.invillia.bank_account_springcore;

import java.util.List;

public interface ClientDAO {
    void insert(Client client);

    List<Client> findAll();

    Client findById(Long id);
}
