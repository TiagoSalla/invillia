package com.invillia.bank_api.domain.response;

import com.invillia.bank_api.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponse {

    private Long id;
    private String name;
    private String cpf;
    private String rg;
    private List<Account> accounts;
    private String createdAt;
    private String updatedAt;
}
