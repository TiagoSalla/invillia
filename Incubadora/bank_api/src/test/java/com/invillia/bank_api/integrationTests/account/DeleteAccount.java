package com.invillia.bank_api.integrationTests.account;

import com.invillia.bank_api.factory.AccountFactory;
import com.invillia.bank_api.repository.AccountRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static javax.servlet.http.HttpServletResponse.SC_NO_CONTENT;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeleteAccount {
    private final AccountFactory accountFactory;
    private final AccountRepository accountRepository;

    @Autowired
    public DeleteAccount(AccountFactory accountFactory, AccountRepository accountRepository) {
        this.accountFactory = accountFactory;
        this.accountRepository = accountRepository;
    }

    @Test
    void deleteSuccessfully(){
        accountFactory.create();

        RestAssured
                .given()
                .log().all()
                .when()
                .delete("/accounts/1")
                .then()
                .log().all()
                .statusCode(SC_NO_CONTENT);

        Assertions.assertEquals(0, accountRepository.count());
    }
}
