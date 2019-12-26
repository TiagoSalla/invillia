package com.invillia.bank_api.factory;

import br.com.leonardoferreira.jbacon.JBacon;
import com.invillia.bank_api.domain.Person;
import com.invillia.bank_api.repository.PersonRepository;
import org.springframework.stereotype.Component;

@Component
public class PersonFactory extends JBacon<Person> {

    private final PersonRepository personRepository;

    public PersonFactory(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    protected Person getDefault() {
        final Person person = new Person();

        person.setName("Jaiminho");
        person.setCpf("55555555555");
        person.setRg("555555559");

        return person;
    }

    @Override
    protected Person getEmpty() {
        return new Person();
    }

    @Override
    protected void persist(Person person) {
        personRepository.save(person);
    }
}
