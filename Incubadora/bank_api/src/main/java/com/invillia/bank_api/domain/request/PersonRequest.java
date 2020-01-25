package com.invillia.bank_api.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequest {

    @NotNull(message = "This field cannot be Null!")
    @NotBlank(message = "This field cannot be Blank!")
    private String name;

    @NotNull(message = "This field cannot be Null!")
    @NotBlank(message = "This field cannot be Blank!")
    private String cpf;

    @NotNull(message = "This field cannot be Null!")
    @NotBlank(message = "This field cannot be Blank!")
    private String rg;

}

