package com.invillia.bank_api.mapper;

import com.invillia.bank_api.domain.Account;
import com.invillia.bank_api.domain.request.AccountRequest;
import com.invillia.bank_api.domain.response.AccountResponse;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public AccountResponse accountToAccountResponse(final Account account){
        final AccountResponse accountResponse = new AccountResponse();

        accountResponse.setId(account.getId());
        accountResponse.setPersonId(account.getPerson().getId());
        accountResponse.setPersonName(account.getPerson().getName());
        accountResponse.setNumber(account.getNumber());
        accountResponse.setAgency(account.getAgency());
        accountResponse.setAccountType(account.getAccountType());
        accountResponse.setBalance(account.getBalance());
        accountResponse.setSpecialLimit(account.getSpecialLimit());
        accountResponse.setCreatedAt(account.getCreatedAt().format(formatter));
        accountResponse.setUpdatedAt(account.getUpdatedAt().format(formatter));

        return accountResponse;
    }

    public List<AccountResponse> accountToAccountResponse(final List<Account> accounts){
        return accounts.stream()
                .map(this::accountToAccountResponse)
                .collect(Collectors.toList());
    }

    public Account accountRequestToAccount(final AccountRequest accountRequest){
        final Account account = new Account();

        account.setNumber(accountRequest.getNumber());
        account.setAgency(accountRequest.getAgency());
        account.setBalance(0.00);
        account.setSpecialLimit(accountRequest.getSpecialLimit());

        return account;
    }

    public void updateAccountByAccountRequest(final Account account, final AccountRequest accountRequest) {
        account.setNumber(accountRequest.getNumber());
        account.setAgency(accountRequest.getAgency());
        account.setSpecialLimit(accountRequest.getSpecialLimit());
    }
}
