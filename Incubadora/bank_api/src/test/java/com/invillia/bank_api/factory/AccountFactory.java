package com.invillia.bank_api.factory;

import br.com.leonardoferreira.jbacon.JBacon;
import com.invillia.bank_api.domain.Account;
import com.invillia.bank_api.enums.AccountType;
import com.invillia.bank_api.repository.AccountRepository;
import org.springframework.stereotype.Component;

@Component
public class AccountFactory extends JBacon<Account> {

    private final AccountRepository accountRepository;
    private final PersonFactory personFactory;

    public AccountFactory(AccountRepository accountRepository, PersonFactory personFactory) {
        this.accountRepository = accountRepository;
        this.personFactory = personFactory;
    }

    @Override
    protected Account getDefault() {
        final Account account = new Account();
        account.setAgency(1234L);
        account.setNumber(1234L);
        account.setAccountType(AccountType.CHECKING);
        account.setPerson(personFactory.create());
        account.setBalance(0D);
        account.setSpecialLimit(0D);

        return account;
    }

    @Override
    protected Account getEmpty() {
        return new Account();
    }

    @Override
    protected void persist(Account account) {
        accountRepository.save(account);
    }
}
