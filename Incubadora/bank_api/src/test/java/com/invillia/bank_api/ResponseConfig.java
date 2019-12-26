package com.invillia.bank_api;

import static javax.servlet.http.HttpServletResponse.SC_NOT_ACCEPTABLE;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

public class ResponseConfig {

    public static ResponseSpecification notFound() {
        return new ResponseSpecBuilder()
                .expectStatusCode(SC_NOT_ACCEPTABLE)
                .expectBody("timestamp", Matchers.not(Matchers.empty()))
                .expectBody("status", Matchers.is(406))
                .expectBody("error", Matchers.is("Not Acceptable"))
                .expectBody("message", Matchers.is("Id não encontrado!"))
                .expectBody("path", Matchers.not(Matchers.empty()))
                .build();
    }
}