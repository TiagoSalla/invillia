import React, { useState, useEffect } from 'react';

import axios from '../../utils/HttpClient';

import { RouterLink, Container } from '../../components/styles';
import { Button, Form, Card } from 'react-bootstrap';

export default function EditPerson(props) {
  const [person, setPerson] = useState({
    person: { name: '', rg: '', cpf: '' },
  });
  const id = props.match.params.id;
  const { push } = props.history;
  const foundPerson = person.person;

  const handleChange = event => {
    const field = event.target.name;
    const { value } = event.target;

    setPerson(({ person }) => ({
      person: {
        ...person,
        [field]: value,
      },
    }));

    console.log(person);
  };

  const handleSubmit = () => {
    axios.put(`/people/${id}`, person.person).then(() => push('/people'));
  };

  useEffect(() => {
    async function retrievePerson() {
      await axios.get(`/people/${id}`).then(({ data }) => {
        const person = {
          name: data.name,
          rg: data.rg,
          cpf: data.cpf,
        };
        setPerson({ person });
      });
    }
    retrievePerson();
  }, [id]);

  return (
    <Container>
      <Card style={{ width: '20rem' }} className="text-center">
        <Card.Header>
          <h1>Editar Pessoa</h1>
        </Card.Header>

        <Card.Body>
          <Container>
            <Form>
              <Form.Row>
                <Form.Group controlId="formGridName">
                  <Form.Label>Nome</Form.Label>
                  <Form.Control
                    name="name"
                    value={foundPerson.name}
                    onChange={handleChange}
                  />
                </Form.Group>
              </Form.Row>
              <Form.Row>
                <Form.Group controlId="formGridRg">
                  <Form.Label>RG</Form.Label>
                  <Form.Control
                    name="rg"
                    value={foundPerson.rg}
                    onChange={handleChange}
                  />
                </Form.Group>
              </Form.Row>
              <Form.Row>
                <Form.Group controlId="formGridCpf">
                  <Form.Label>CPF</Form.Label>
                  <Form.Control
                    name="cpf"
                    value={foundPerson.cpf}
                    onChange={handleChange}
                  />
                </Form.Group>
              </Form.Row>
              <Button variant="danger">
                <RouterLink to="/people">Voltar</RouterLink>
              </Button>{' '}
              <Button
                variant="success"
                onClick={() => {
                  handleSubmit();
                }}
              >
                Salvar
              </Button>
            </Form>
          </Container>
        </Card.Body>
      </Card>
    </Container>
  );
}
