package com.invillia.bank_api.controller;

import com.invillia.bank_api.domain.request.PersonRequest;
import com.invillia.bank_api.domain.response.PersonResponse;
import com.invillia.bank_api.service.PersonService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<PersonResponse> findAll(){
        return personService.findAll();
    }

    @PostMapping
    public HttpEntity<?> create(@Valid @RequestBody final PersonRequest personRequest){
        final Long id = personService.create(personRequest);

        final URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/people/{id}").build(id);

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public PersonResponse findById(@PathVariable final Long id){
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteById(@PathVariable final Long id){
        personService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable final Long id, @Valid @RequestBody PersonRequest personRequest){
        personService.update(id, personRequest);

        return ResponseEntity.noContent().build();
    }

}
