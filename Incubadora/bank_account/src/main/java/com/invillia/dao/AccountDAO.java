package com.invillia.dao;

import com.invillia.domain.Account;
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

    public void listById(Long id) {
        Messages.accountFindByIdMessage(findById(id));
    }

    public Account findById(Long id) {
        return entityManager.find(Account.class, id);
    }

    public void update(Account account){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(account);
        transaction.commit();
    }

    public void deleteById(Long id) {
        listById(id);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Account account = findById(id);
        entityManager.remove(account);
        transaction.commit();
    }

    public void verifyBalance(Long id){
        Account account = findById(id);
        Messages.showMessage("Saldo da Conta: R$" + account.getBalance());
    }

    public void verifySpecialLimit(Long id){
        Account account = findById(id);
        Messages.showMessage("Limite de Cheque Especial:" +
                            "\n\n" +
                            "Disponível: R$" +
                            account.getAvailableSpecialLimit() +
                            "\n" +
                            "Utilizado: R$" +
                            (account.getSpecialLimit() - account.getAvailableSpecialLimit()) +
                            "\n" +
                            "Total: R$" +
                            account.getSpecialLimit());
    }

    public void deposit(Long id){
        Account account = findById(id);
        Double value = Messages.daoDoubleInputMessage("Qual valor você deseja depositar?");

        Double balance = account.getBalance();
        Double availableSpecialLimit = account.getAvailableSpecialLimit();
        Double specialLimit = account.getSpecialLimit();
        Double diference = specialLimit - availableSpecialLimit;

        if(availableSpecialLimit < specialLimit){
            if(value > diference){
                availableSpecialLimit = specialLimit;
                balance = value - diference;
            }else{
                availableSpecialLimit += value;
            }
        }else{
            balance += value;
        }

        account.setBalance(balance);
        account.setAvailableSpecialLimit(availableSpecialLimit);
        update(account);

        Messages.showMessage("Depósito efetuado com sucesso!");
    }

    public void withdraw(Long id){
        Account account = findById(id);
        Double value = Messages.daoDoubleInputMessage("Qual valor você deseja sacar?");

        Double balance = account.getBalance();
        Double specialLimit = account.getAvailableSpecialLimit();

        if(value <= balance + specialLimit){
            if(value > balance){
                specialLimit = (specialLimit + balance) - value;
                balance = 0.0;
            }else{
                balance -= value;
            }

            account.setBalance(balance);
            account.setAvailableSpecialLimit(specialLimit);
            update(account);

            Messages.showMessage("Saque efetuado com sucesso!");
        }else{
            Messages.showMessage("Não há limite disponível na conta para realizar o saque!");
        }
    }
}