package com.invillia.bank_api.factory;

import br.com.leonardoferreira.jbacon.JBacon;
import com.invillia.bank_api.domain.request.AccountRequest;
import com.invillia.bank_api.enums.AccountType;

public class AccountRequestFactory extends JBacon<AccountRequest> {

    private final PersonFactory personFactory;

    public AccountRequestFactory(PersonFactory personFactory) {
        this.personFactory = personFactory;
    }

    @Override
    protected AccountRequest getDefault() {
        final AccountRequest accountRequest = new AccountRequest();

        accountRequest.setPersonId(personFactory.create().getId());
        accountRequest.setAccountType(AccountType.CHECKING.toString());
        accountRequest.setAgency(1234L);
        accountRequest.setNumber(1234L);
        accountRequest.setSpecialLimit(0D);

        return accountRequest;
    }

    @Override
    protected AccountRequest getEmpty() {
        return new AccountRequest();
    }

    @Override
    protected void persist(AccountRequest accountRequest) {
        throw new UnsupportedOperationException();
    }
}
