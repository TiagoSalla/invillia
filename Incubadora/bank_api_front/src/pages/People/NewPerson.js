import React, { useState } from 'react';

import axios from '../../utils/HttpClient';

import { RouterLink, Container } from '../../components/styles';
import { Button, Form, Card } from 'react-bootstrap';

export default function NewPerson(props) {
  const [person, setPerson] = useState({
    person: { name: '', rg: '', cpf: '' },
  });
  const { push } = props.history;

  const handleSubmit = () => {
    axios.post(`/people`, person.person).then(() => push('/people'));
  };

  const handleChange = event => {
    const field = event.target.name;
    const { value } = event.target;

    setPerson(({ person }) => ({
      person: {
        ...person,
        [field]: value,
      },
    }));
  };

  return (
    <Container>
      <Card style={{ width: '20rem' }} className="text-center">
        <Card.Header>
          <h1>Nova Pessoa</h1>
        </Card.Header>

        <Card.Body>
          <Container>
            <Form>
              <Form.Row>
                <Form.Group controlId="formGridName">
                  <Form.Label>Nome</Form.Label>
                  <Form.Control
                    name="name"
                    value={person.name}
                    onChange={handleChange}
                  />
                </Form.Group>
              </Form.Row>
              <Form.Row>
                <Form.Group controlId="formGridRg">
                  <Form.Label>RG</Form.Label>
                  <Form.Control
                    name="rg"
                    value={person.rg}
                    onChange={handleChange}
                  />
                </Form.Group>
              </Form.Row>
              <Form.Row>
                <Form.Group controlId="formGridCpf">
                  <Form.Label>CPF</Form.Label>
                  <Form.Control
                    name="cpf"
                    value={person.cpf}
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
                Criar
              </Button>
            </Form>
          </Container>
        </Card.Body>
      </Card>
    </Container>
  );
}
