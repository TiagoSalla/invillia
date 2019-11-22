package com.invillia.bank_api.service;

import com.invillia.bank_api.domain.Person;
import com.invillia.bank_api.domain.request.PersonRequest;
import com.invillia.bank_api.domain.response.PersonResponse;
import com.invillia.bank_api.exception.ResourceNotFoundException;
import com.invillia.bank_api.mapper.PersonMapper;
import com.invillia.bank_api.repository.PersonRepository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Transactional(readOnly = true)
    public PersonResponse findById(final Long id){
        return personRepository.findById(id)
                .map(personMapper :: personToPersonResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
    }

    @Transactional(readOnly = true)
    public List<PersonResponse> findAll(){
        final List<Person> people = personRepository.findAll();
        return personMapper.personToPersonResponse(people);
    }

    @Transactional
    public Long create(final PersonRequest personRequest){
        Person person = personMapper.personRequestToPerson(personRequest);
        personRepository.save(person);

        return person.getId();
    }

    @Transactional
    public void deleteById(final Long id){
        final Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        personRepository.delete(person);
    }

    @Transactional
    public void update(final Long id, final PersonRequest personRequest){
        Person person = personRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        personMapper.updatePersonByPersonRequest(person, personRequest);

        personRepository.save(person);
    }
}
