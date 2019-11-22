package com.invillia.bank_api.service;

import com.invillia.bank_api.domain.Account;
import com.invillia.bank_api.domain.request.AccountRequest;
import com.invillia.bank_api.domain.response.AccountResponse;
import com.invillia.bank_api.enums.AccountType;
import com.invillia.bank_api.exception.InvalidValueException;
import com.invillia.bank_api.exception.ResourceNotFoundException;
import com.invillia.bank_api.mapper.AccountMapper;
import com.invillia.bank_api.repository.AccountRepository;
import com.invillia.bank_api.repository.PersonRepository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final PersonRepository personRepository;
    private final AccountMapper accountMapper;


    public AccountService(AccountRepository accountRepository,
                          PersonRepository personRepository,
                          AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.personRepository = personRepository;
        this.accountMapper = accountMapper;
    }

    @Transactional(readOnly = true)
    public AccountResponse findById(final Long id){
        return accountRepository.findById(id)
                .map(accountMapper::accountToAccountResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found!"));
    }

    @Transactional(readOnly = true)
    public List<AccountResponse> findAll(){
        List<Account> accounts = accountRepository.findAll();

        return accountMapper.accountToAccountResponse(accounts);
    }

    @Transactional
    public Long create(final AccountRequest accountRequest){
        Account account = new Account();

        account = accountMapper.accountRequestToAccount(accountRequest);

        account.setPerson(personRepository
                .findById(accountRequest.getPersonId())
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!")));

        if(accountRequest.getAccountType().equals("SAVING"))
            account.setAccountType(AccountType.SAVING);
        else if(accountRequest.getAccountType().equals("CHECKING"))
            account.setAccountType(AccountType.CHECKING);
        else
            throw new InvalidValueException("Invalid account type!");

        accountRepository.save(account);

        return account.getId();
    }

    @Transactional
    public void deleteById(final Long id){
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found!"));

        accountRepository.delete(account);
    }

    @Transactional
    public void update(final Long id, AccountRequest accountRequest){
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found!"));

        if(accountRequest.getPersonId() != null){
            account.setPerson(personRepository
                    .findById(accountRequest.getPersonId())
                    .orElseThrow(() -> new ResourceNotFoundException("Person not found!")));
        }

        if(accountRequest.getAccountType() != null){
            if(accountRequest.getAccountType().equals("SAVING"))
                account.setAccountType(AccountType.SAVING);
            else if(accountRequest.getAccountType().equals("CHECKING"))
                account.setAccountType(AccountType.CHECKING);
            else
                throw new InvalidValueException("Invalid account type!");
        }

        accountMapper.updateAccountByAccountRequest(account, accountRequest);

        accountRepository.save(account);
    }

}
