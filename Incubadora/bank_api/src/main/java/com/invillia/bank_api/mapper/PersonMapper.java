package com.invillia.bank_api.mapper;

import com.invillia.bank_api.domain.Person;
import com.invillia.bank_api.domain.request.PersonRequest;
import com.invillia.bank_api.domain.response.PersonResponse;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public PersonResponse personToPersonResponse(final Person person){
        final PersonResponse personResponse = new PersonResponse();

        personResponse.setId(person.getId());
        personResponse.setName(person.getName());
        personResponse.setCpf(person.getCpf());
        personResponse.setRg(person.getRg());
        personResponse.setAccounts(person.getAccounts());
        personResponse.setCreatedAt(person.getCreatedAt().format(formatter));
        personResponse.setUpdatedAt(person.getUpdatedAt().format(formatter));

        return personResponse;
    }

    public List<PersonResponse> personToPersonResponse(final List<Person> people){
        return people.stream()
                .map(this::personToPersonResponse)
                .collect(Collectors.toList());
    }

    public Person personRequestToPerson(final PersonRequest personRequest){
        final Person person = new Person();

        person.setName(personRequest.getName());
        person.setCpf(personRequest.getCpf());
        person.setRg(personRequest.getRg());

        return person;
    }

    public void updatePersonByPersonRequest(final Person person, final PersonRequest personRequest) {
        person.setName(personRequest.getName());
        person.setCpf(personRequest.getCpf());
        person.setRg(personRequest.getRg());
    }
}
