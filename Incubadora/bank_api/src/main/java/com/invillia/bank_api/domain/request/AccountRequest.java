package com.invillia.bank_api.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {

    private Long personId;

    @NotNull(message = "This field cannot be Null!")
    private Long number;

    @NotNull(message = "This field cannot be Null!")
    private Long agency;

    private String accountType;

    @NotNull(message = "This field cannot be Null!")
    private Double specialLimit;

}
