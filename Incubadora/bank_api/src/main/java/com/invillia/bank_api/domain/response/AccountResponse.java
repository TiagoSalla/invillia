package com.invillia.bank_api.domain.response;

import com.invillia.bank_api.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {

    private Long id;
    private Long personId;
    private String personName;
    private Long number;
    private Long agency;
    private AccountType accountType;
    private Double balance;
    private Double specialLimit;
    private String createdAt;
    private String updatedAt;
}