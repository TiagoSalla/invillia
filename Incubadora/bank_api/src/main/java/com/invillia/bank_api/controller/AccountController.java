package com.invillia.bank_api.controller;

import com.invillia.bank_api.domain.request.AccountRequest;
import com.invillia.bank_api.domain.response.AccountResponse;
import com.invillia.bank_api.service.AccountService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountResponse> findAll(){
        return accountService.findAll();
    }

    @PostMapping
    public HttpEntity<?> create(@Valid @RequestBody AccountRequest accountRequest){
        final Long id = accountService.create(accountRequest);

        final URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/accounts/{id}").build(id);

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public AccountResponse findById(@PathVariable final Long id){
        return accountService.findById(id);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteById(@PathVariable final Long id){
        accountService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable final Long id, @Valid @RequestBody AccountRequest accountRequest){
        accountService.update(id, accountRequest);

        return ResponseEntity.noContent().build();
    }

}
