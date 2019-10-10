package com.invillia.dao;

import com.invillia.domain.Client;
import com.invillia.swing.Messages;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClientDAO {
    private EntityManager entityManager;

    public ClientDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void insert(Client client){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(client);
        transaction.commit();
    }

    public void listAll(){
        TypedQuery<Client> client = entityManager.createQuery("from Client", Client.class);
        Messages.clientListMessage(client.getResultList());
    }

    public void listById(Long id){
        Messages.clientFindByIdMessage(findById(id));
    }

    public Client findById(Long id){
        return entityManager.find(Client.class, id);
    }

    public void update(Long id){
        Client client = findById(id);

        listById(client.getId());

        client.setName(Messages.daoStringInputMessage("Insira o novo nome para esse cliente:"));
        client.setCpf(Messages.daoStringInputMessage("Insira o novo CPF para esse cliente:"));
        client.setRg(Messages.daoStringInputMessage("Insira o novo RG para esse cliente:"));

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(client);
        transaction.commit();
    }

    public void deleteById(Long id){
        listById(id);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Client client = findById(id);
        entityManager.remove(client);
        transaction.commit();
    }



}
