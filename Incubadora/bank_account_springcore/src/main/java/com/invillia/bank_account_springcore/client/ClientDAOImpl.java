package com.invillia.bank_account_springcore;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClientDAOImpl implements ClientDAO{

    private final EntityManager entityManager;

    public ClientDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private List<Client> clients = new ArrayList<>();

    @Override
    public void insert(Client client) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(client);
        transaction.commit();
    }

    @Override
    public List<Client> findAll() {
        TypedQuery<Client> client = entityManager.createQuery("from Client", Client.class);
        return client.getResultList();
    }

    @Override
    public Client findById(Long id) {
        return entityManager.find(Client.class, id);

        //return clients.stream().filter(client -> client.getId().equals(id)).findFirst();
    }
}
