package com.invillia.dao;

import com.invillia.domain.Account;
import com.invillia.domain.Client;
import com.invillia.swing.Messages;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class AccountDAO {
    private EntityManager entityManager;

    public AccountDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Account account) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(account);
        transaction.commit();
    }

    public void listAll() {
        TypedQuery<Account> account = entityManager.createQuery("from Account", Account.class);
        Messages.accountListMessage(account.getResultList());
    }
//
//    public void listById(Long id) {
//        Messages.accountFindByIdMessage(findById(id));
//    }
//
//    public Account findById(Long id) {
//        return entityManager.find(Account.class, id);
//    }
//
//    public void update(Long id) {
//        Account client = findById(id);
//
//        listById(client.getId());
//
//        client.setName(Messages.daoStringInputMessage("Insira o novo nome para esse cliente:"));
//        client.setCpf(Messages.daoStringInputMessage("Insira o novo CPF para esse cliente:"));
//        client.setRg(Messages.daoStringInputMessage("Insira o novo RG para esse cliente:"));
//
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        entityManager.merge(client);
//        transaction.commit();
//    }
//
//    public void deleteById(Long id) {
//        listById(id);
//
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        Account account = findById(id);
//        entityManager.remove(account);
//        transaction.commit();
//    }
}