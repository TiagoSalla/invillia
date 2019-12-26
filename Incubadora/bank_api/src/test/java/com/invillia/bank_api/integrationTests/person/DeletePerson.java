package com.invillia.bank_api.integrationTests.person;

import static org.apache.http.HttpStatus.SC_NO_CONTENT;

import com.invillia.bank_api.ResponseConfig;
import com.invillia.bank_api.factory.PersonFactory;
import com.invillia.bank_api.repository.PersonRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeletePerson {
    private final PersonFactory personFactory;
    private final PersonRepository personRepository;

    @Autowired
    public DeletePerson(PersonFactory personFactory, PersonRepository personRepository) {
        this.personFactory = personFactory;
        this.personRepository = personRepository;
    }

    @Test
    void deleteSuccessfully(){
        personFactory.create();

        RestAssured
                .given()
                    .log().all()
                .when()
                    .delete("/people/1")
                .then()
                    .log().all()
                    .statusCode(SC_NO_CONTENT);

        Assertions.assertEquals(0, personRepository.count());
    }
}
